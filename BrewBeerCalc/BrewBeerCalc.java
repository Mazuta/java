/*
* �������� ��������� �������
*
*       BrewBeerCalc [����� ����� ����� ���������] [��������� �����] [��� �����: Wh - �����, Ph - �������]
*                   [��� ����� � ������] [ ����������� ALPHA %] [����� ����� � �������]
*
* */

import java.lang.Float;
import java.lang.Integer;
import java.lang.Math;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BrewBeerCalc{

    public static void main( String[] args){

        if (args.length != 0){

            //������������ ���������� ���������� ���� ��������� �������

            float Obem_susla = Float.valueOf(args[0]);
            float Plotnost_susla = Float.valueOf(args[1]);
            String Tip_hvelia = new String(args[2]);
            String Ph = new String("Ph");
            String Wh = new String("Wh");
            float Ves_hmelia = Float.valueOf(args[3]);
            float Alpha_hmelia = Float.valueOf(args[4]);
            int Vremia_varki = Integer.valueOf(args[5]);
            double Utilisacia_hmelia =0;
            double IBU = 0;
            float Obem_soloda = 0.0f;
            float Voda_zatirania =0.0f;
            float Voda_promivania =0.0f;
            float Voda = 0.0f;

            //������ ������ ������ ������
            Obem_soloda = Obem_susla / 5;

            //������ ������ ���� ��� ��������� ������
            Voda_zatirania = Obem_susla * 0.8f * 10;
            Voda_zatirania = Math.round(Voda_zatirania);
            Voda_zatirania = Voda_zatirania / 10;

            //������ ������ ���� ��� ����������
            Voda_promivania = Obem_susla * 0.6f * 10;
            Voda_promivania = Math.round(Voda_promivania);
            Voda_promivania = Voda_promivania / 10;

            //����� ����� ����
            Voda = Voda_zatirania + Voda_promivania;

            //������ ���������� �����
            Utilisacia_hmelia = (1.65 * Math.pow(0.000125,Plotnost_susla - 1)) * ((1 - Math.exp(-0.04 * Vremia_varki)) / 4.15);

            //��������� �������� ���������� ��� ���� ����� (Wh - ��������, Ph - ���������������)
            if (Tip_hvelia.equals(Ph)){
                Utilisacia_hmelia = Utilisacia_hmelia * 1.1;
            }

            //������ IBU
            IBU = Utilisacia_hmelia * (((Alpha_hmelia / 100) * (Ves_hmelia * 0.0352739619) * 7490) / (Obem_susla * 0.264172052));
            //���������� �� 0.00
            IBU = IBU * 100;
            IBU = Math.round(IBU);
            IBU = IBU / 100;

            //����� ������ � ����������� �� �����
            System.out.println("\n" +
                    "������, ����������� �� ������ ����� ������:" +
                    "\n" +
                    "����������� ����� ����� ������: " + Obem_soloda + " ��.\n" +
                    "��� ��������� ������ ����� ������������ " + Voda_zatirania + " �. ����.\n" +
                    "��� �������� ������� ����� ������������ " + Voda_promivania + " �. ����.\n" +
                    "����� ����� ��� ����� ������ ���� ������ " + Voda + " �.\n" +
                    "\n" +
                    "�����:\n" +
                    "�������� �1 " + Ves_hmelia + " �. � ALPHA = " + Alpha_hmelia + "% �� " + Vremia_varki + " ���. �� ����� �����.\n" +
                    "��������� IBU ����: "+ IBU + " ������.");
        }else{

            //����� ������� ���� ��������� �� �������
            System.out.println("������! �������� �� ����� ����������� �������� ������ ���������� ������������ � �����������:\n" +
                    "\n" +
                    "BrewBeerCalc [����� ����� ����� ���������] [��������� �����] [��� �����: Wh - �����, Ph - �������]\n" +
                    "   [��� ����� � ������] [ ����������� ALPHA %] [����� ����� � �������]");
        }

    }

}
