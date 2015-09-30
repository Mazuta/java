import java.lang.Double;
import java.lang.String;
import java.nio.IntBuffer;
import java.util.Arrays;

public class BeerCalc {



    //���������� ����������

    String[][] solod = new String[5][4];    //������ ����������� �������
    String[][] hmel = new String[0][6];     //������ ����������� ������
    float start_plotnost = 1.055f;          //��������� ��������� ����� �� �������� �� ��������� = 1.055 SG
    float finish_plotnost = 1.005f;         //��������� ����� ����� �������� �� ��������� = 1.005 SG



    //�������������� ��������� ����������� ����

    double IBU = 0.00d;                     //IBU �������� �������
    float obiom = 0.00f;                    //����� �������� ������� (�� �� ����� ����� �� � ����� ��������)
    String color = new String();            //���� �������� �������
    float Alkch  = 0.00f;                   //���������� ���������� �������� � ������� �������



    //���������� ����������

    static int SolodNumber = 0;             //������� ����� � ������� ������
    static int HmelNumber = 0;              //������� ����� � ������� �����
    static double Utilisacia_hmelia;        //������ �����
    static float hmel_type = 1f;            //����������� ������ �����. ��� ����� = 1; ��� ������ = 1.1



    //���������� �������� (������) � ������ ��������������� �������

    public boolean addElement(String Company, String Name, String Massa, String Color){



        // ���� �������� �������� � ������ ������ ���� ��������� �� ������� ���������� false
        if (SolodNumber > 4) {
            return false;
        }

        this.solod[SolodNumber][0] = Company;
        this.solod[SolodNumber][1] = Name;
        this.solod[SolodNumber][2] = Massa;
        this.solod[SolodNumber][3] = Color;

        SolodNumber++;



        // ���� ������� ����������� ������� �� ���������� true
        return true;
    }



    //���������� �������� (�����) � ������ ��������������� �������

    public void addElement(String Company, String Name, String Type, String Massa, String Alpha ,String TimeV){



        //������� ��������� ������ tempArray � ����������� ����� �� 1 ������ ������� hmel

        String[][] tempArray = new String[hmel.length+1][6];



        //���������� ���� ����� ������� hmel[][] ���������� ������� tempArray[][]

        for (int i = 0; i < hmel.length; i++){
            for(int k = 0; k <= 5; k++){tempArray[i][k]=hmel[i][k];}
        }



        //���������� � ��������� ��������� ������ �������� �� ����������

        tempArray[tempArray.length-1][0] = Company;
        tempArray[tempArray.length-1][1] = Name;
        tempArray[tempArray.length-1][2] = Type;
        tempArray[tempArray.length-1][3] = Massa;
        tempArray[tempArray.length-1][4] = Alpha;
        tempArray[tempArray.length-1][5] = TimeV;



        //���������������� ������� hmel[][] ��������� ������ ������� tempArray[][]

        hmel = new String[tempArray.length][6];



        //���������� ���� ����� ������� tempArray[][] ������� ������� hmel[][]

        for (int i = 0; i < tempArray.length; i++) {
            for (int k = 0; k <= 5; k++){hmel[i][k] = tempArray[i][k];}
        }
    }



    //���������� ���������� ����� �� � ����� �������� � ������ ��������������� �������

    public boolean addElement(float Obiom, float Plotnost_before, float Plotnost_after){

        this.obiom = Obiom;
        this.start_plotnost = Plotnost_before;
        this.finish_plotnost = Plotnost_after;

        return true;
    }



    //��������� ���������� ������������

    public void resetCalc(){



        //������� ������� hmel (��������������� � ������� ����������� �����)

        this.hmel = new String[0][6];



        //��������� ����������, ������������ � �������� � �����������

        this.start_plotnost = 1.055f;
        this.finish_plotnost = 1.005f;
        this.IBU = 0d;
        this.obiom = 0.00f;
        this.color = "";
        this.Alkch  = 0.00f;

    }



    //������ ���������� ����

    public void mathsBeer(){



        //������ ���������� �������� IBU ��� ���� �������� �����

        for (int i = 0; i <= hmel.length; i++){

            this.IBU = mathsIBU(i);
        }

    }



    //������ IBU � ������ ���� �������� �����

    private double mathsIBU(int NumberRow){

        double tempIBU;



        //���������� ������ �����

        this.Utilisacia_hmelia = (1.65 * Math.pow(0.000125,this.start_plotnost - 1)) *
                ((1 - Math.exp(-0.04 * Double.valueOf(this.hmel[NumberRow][5]))) / 4.15);

        switch (this.hmel[NumberRow][2]){

            case "Whole":                           //���� ��� ����� �����
                this.hmel_type = 1f;
                break;

            case "Pellet":
                this.hmel_type = 1.1f;              //���� ��� ����� �������
                break;
        }



        //��������� �������� ������ ����� � ����������� �� ���� �����

        this.Utilisacia_hmelia *= this.hmel_type;



        //����������� IBU

        tempIBU = this.Utilisacia_hmelia * (((Float.valueOf(this.hmel[NumberRow][4]) / 100) *
                (Float.valueOf(this.hmel[NumberRow][3]) * 0.0352739619) * 7490) / (this.obiom * 0.264172052));

        return roundRes(tempIBU, 100);
    }



    //��������� ��������

    /*

    ��� ���� ����� ��������� �������� 0.0000000 �� 0.00 ���������� arg =0.0000000, ostatok = 100

     */

    private static double roundRes(double arg, int ostatok){

        double temp;

        temp = arg * ostatok;
        temp = Math.round(temp);
        temp = temp / ostatok;

        return temp;
    }
}