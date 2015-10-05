package ru.beercalc.v2;

/**
 * Malt - солод.
 *
 * Данный класс описывает семейство объектов СОЛОД и их основными параметрами:
 *
 *         providerName - название компании поставщика (Пример: Castle Malting), поумолчанию null;
 *         productName - название солода (Пример: Chateau Pilsen), поумолчанию null;
 *         weight - вес в кг (Пример: 1.5 кг), поумолчанию 0;
 *         colorEBC - цветность солода по системе EBC (Пример: 3), поумолчанию 0;
 *
 * Для удобства задания значение предусмотрен конструктор в одну строку.
 *
 * Примеры создания объектов класса Malt и задание параметров
 *
 * Пример 1:
 *
 *         Malt solod = new Malt();
 *
 *              solod.providerName = "Castle Malting";
 *              solod.productName = "Chateau Pilsen";
 *              solod.weight = 1.5;
 *              solod.colorEBC = 3;
 *
 * Пример 2:
 *
 *         Malt solod = new Malt("Castle Malting", "Chateau Pilsen", 1.5, 3);
 */


public class Malt {



    // ����������� �����������

    Malt(){
        this.providerName = null;
        this.productName = null;
        this.weight = 0;
        this.colorEBC = 0;
    }



    // ����������� � ���� ������

    Malt(String providerName, String productName, double weight, int colorEBC){

        this.providerName = providerName;
        this.productName = productName;
        this.weight = weight;
        this.colorEBC = colorEBC;
    }



    // ��������� ������

    String providerName, productName;
    double weight;
    int colorEBC;

    public static void main(String[] args){

        Malt solod = new Malt();
            solod.providerName = "Поставщик";
            solod.productName = "Марка";
            solod.weight = 1.5;
            solod.colorEBC = 3;

        System.out.print(solod.providerName + " ");
        System.out.print(solod.productName + " ");
        System.out.print(solod.weight + " ");
        System.out.println(solod.colorEBC);
    }
}
