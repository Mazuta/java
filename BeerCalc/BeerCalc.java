import java.lang.Double;
import java.lang.String;
import java.nio.IntBuffer;
import java.util.Arrays;

public class BeerCalc {



    //���������� ����������

    String[][] solod = new String[0][4];    //������ ����������� �������
    String[][] hmel = new String[0][6];     //������ ����������� ������
    double start_plotnost = 1.055;          //��������� ��������� ����� �� �������� �� ��������� = 1.055 SG
    double finish_plotnost = 1.005;         //��������� ����� ����� �������� �� ��������� = 1.005 SG



    //�������������� ��������� ����������� ����

    double IBU = 0.00;                      //IBU �������� �������
    double obiom = 0.00;                    //����� �������� ������� (�� �� ����� ����� �� � ����� ��������)
    String color = new String();            //���� �������� �������
    double Alkch  = 0.00;                   //���������� ���������� �������� � ������� �������



    //���������� ����������

    static int SolodNumber = 0;             //������� ����� � ������� ������
    static int HmelNumber = 0;              //������� ����� � ������� �����
    static double Utilisacia_hmelia;        //������ �����
    static double hmel_type = 1;            //����������� ������ �����. ��� ����� = 1; ��� ������ = 1.1



    //���������� �������� (������) � ������ ��������������� �������

    public void addElement(String Company, String Name, String Massa, String Color){



        //������� ��������� ������ tempArray � ����������� ����� �� 1 ������ ������� solod

        String[][] tempArray = new String[solod.length+1][4];



        //���������� ���� ����� ������� solod[][] ���������� ������� tempArray[][]

        for (int i = 0; i < solod.length; i++){
            for(int k = 0; k <= 3; k++){tempArray[i][k]=solod[i][k];}
        }



        //���������� � ��������� ��������� ������ �������� �� ����������

        tempArray[tempArray.length-1][0] = Company;
        tempArray[tempArray.length-1][1] = Name;
        tempArray[tempArray.length-1][2] = Massa;
        tempArray[tempArray.length-1][3] = Color;



        //���������������� ������� solod[][] ��������� ������ ������� tempArray[][]

        solod = new String[tempArray.length][4];



        //���������� ���� ����� ������� tempArray[][] ������� ������� solod[][]

        for (int i = 0; i < tempArray.length; i++) {
            for (int k = 0; k <= 3; k++){solod[i][k] = tempArray[i][k];}
        }
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

    public boolean addElement(double Obiom, double Plotnost_before, double Plotnost_after){

        this.obiom = Obiom;
        this.start_plotnost = Plotnost_before;
        this.finish_plotnost = Plotnost_after;

        return true;
    }



    //��������� ���������� ������������

    public void resetCalc(){



        //������� �������� solod � hmel (��������������� � ������� ����������� �����)

        this.hmel = new String[0][6];
        this.solod = new String[0][4];



        //��������� ����������, ������������ � �������� � �����������

        this.start_plotnost = 1.055;
        this.finish_plotnost = 1.005;
        this.IBU = 0d;
        this.obiom = 0.00;
        this.color = "";
        this.Alkch  = 0.00;

    }



    //������ ���������� ����

    public void mathsBeer(){



        //������ ���������� �������� IBU ��� ���� �������� �����

        for (int i = 0; i < hmel.length; i++){

            this.IBU = mathsIBU(i);
        }



        //����������� ������ �����/���� �� ���������

        this.obiom = mathsObiom_Default();

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

        tempIBU = this.Utilisacia_hmelia * (((Double.valueOf(this.hmel[NumberRow][4]) / 100) *
                (Double.valueOf(this.hmel[NumberRow][3]) * 0.0352739619) * 7490) / (this.obiom * 0.264172052));

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




    //����������� ��������� ����� ������� �� ��������� (�� ����������� �����/���� = 1/5)

    private double mathsObiom_Default(){

        double All_mass_solod = 0;



        //��������� ����� ���� ������� � ������
        for (int i = 0; i < this.solod.length; i++){All_mass_solod += Double.valueOf(solod[i][2]);}



        //������ ���� �� ����������� 1/5

        return All_mass_solod * 5;
    }
}