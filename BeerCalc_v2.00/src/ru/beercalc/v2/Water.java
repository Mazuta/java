package ru.beercalc.v2;

/**
 * Water - ����.
 *
 *
 *
 * ������ ����� ��������� ��������� �������� ���� � �� ��������� �����������:
 *
 *         name - �������� (������: ����������� ���� (��� ���� ��� ���������)), ����������� null;
 *
 *         volume - ����� � � (������: 15 �.), ����������� 0;
 *
 *         temp - ����������� � �������� ������� (������: 25 ����/�������), ����������� 0;
 *
 *
 *
 * ��� �������� ������� �������� ������������ ����������� � ���� ������.
 *
 *
 *
 * ������� �������� �������� ������ Water � ������� ����������
 *
 * ������ 1:
 *
 *         Water voda = new Water();
 *
 *              voda.name = "����������� ����";
 *              voda.volume = 15;
 *              voda.temp = 25;
 *
 * ������ 2:
 *
 *         Water voda = new Water("����������� ����", 15, 25);
 */


public class Water {



    // ����������� �� ���������

    Water(){
        this.name = null;
        this.temp = 0;
        this.volume = 0;

    }



    // ����������� � ���� ������

    Water(String name, double volume, double temp){

        this.name = name;
        this.temp = temp;
        this.volume = volume;

    }



    // �������� �������� ������ Water

    String name;
    double temp, volume;

}