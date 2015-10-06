package ru.beercalc.v2;

/**
 * Wort - сусло.
 *
 *
 *
 * Данный класс описывает семейство объектов СУСЛО и их основными параметрами:
 *
 *         volume - объём собранного сусла в л. (Пример: 15л.), поумолчанию 0;
 *
 *         densityBefore - плотность сусла до брожения в SG (Пример: 1.055), поумолчанию 0;
 *
 *         densityAfter - плотность сусла после брожения в SG (Пример: 1.022), поумолчанию 0;
 *
 *
 *
 * Для удобства задания значение предусмотрен конструктор в одну строку.
 *
 *
 *
 * Примеры создания объектов класса Wort и задание параметров
 *
 * Пример 1:
 *
 *         Wort suslo = new Wort();
 *
 *              suslo.volume = 15;
 *              suslo.densityBefore = 1.055;
 *              suslo.densityAfter = 1.022;
 *
 * Пример 2:
 *
 *         Wort suslo = new Wort(15, 1.055, 1.022);
 */


public class Wort {



    // Конструктор по умолчанию

    Wort(){
        this.volume = 0;
        this.densityBefore = 0;
        this.densityAfter = 0;

    }



    // Констркутор в одну строку

    Wort(double volume, double densityBefore, double densityAfter){

        this.volume = volume;
        this.densityBefore = densityBefore;
        this.densityAfter = densityAfter;

    }



    // Свойства объектов класса Wort

    double volume, densityBefore, densityAfter;

}