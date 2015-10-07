package ru.beercalc.v2;

/**
 * Beer - пиво.
 *
 *
 *
 * Данный класс описывает семейство объектов ПИВО и их основными параметрами:
 *
 *         volume - объём полкченного пива (Пример: 15), поумолчанию 0;
 *
 *         IBU - горечь полученного пива по международной классификации (Пример: 48), поумолчанию 0;
 *
 *         alkhl - примерное процентное содержание алкоголя в полученном пиве (Пример: 6.25%), поумолчанию 0;
 *
 *         colorEBC - цветность полученного пива (Пример: 50), поумолчанию 0;
 *
 *
 *
 * Для удобства задания значение предусмотрен конструктор в одну строку.
 *
 *
 *
 * Примеры создания объектов класса Hops и задание параметров
 *
 * Пример 1:
 *
 *         Beer pivo = new Beer();
 *
 *              pivo.volume = 15;
 *              pivo.IBU = 48;
 *              pivo.alkhl = 6.25;
 *              pivo.colorEBC = 50;
 *
 * Пример 2:
 *
 *         Beer pivo = new Beer(15, 48, 6.25, 50);
 */


public class Beer {



    // Конструктор по умолчанию

    Beer(){
        this.volume = 0;
        this.IBU = 0;
        this.alkhl = 0;
        this.colorEBC = 0;

    }



    // Констркутор в одну строку

    Beer(double volume, double IBU, double alkhl, double colorEBC){

        this.volume = volume;
        this.IBU = IBU;
        this.alkhl = alkhl;
        this.colorEBC = colorEBC;

    }



    // Свойства объектов класса Hops

    double volume, colorEBC, IBU, alkhl;

}