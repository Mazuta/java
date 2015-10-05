package ru.beercalc.v2;

/**
 * Water - вода.
 *
 *
 *
 * Данный класс описывает семейство объектов ВОДА и их основными параметрами:
 *
 *         name - название (Пример: Промывочная вода (или Вода для затирания)), поумолчанию null;
 *
 *         volume - объём в л (Пример: 15 л.), поумолчанию 0;
 *
 *         temp - темперетура в градусах цельсия (Пример: 25 град/цельсия), поумолчанию 0;
 *
 *
 *
 * Для удобства задания значение предусмотрен конструктор в одну строку.
 *
 *
 *
 * Примеры создания объектов класса Water и задание параметров
 *
 * Пример 1:
 *
 *         Water voda = new Water();
 *
 *              voda.name = "Промывочная вода";
 *              voda.volume = 15;
 *              voda.temp = 25;
 *
 * Пример 2:
 *
 *         Water voda = new Water("Промывочная вода", 15, 25);
 */


public class Water {



    // Конструктор по умолчанию

    Water(){
        this.name = null;
        this.temp = 0;
        this.volume = 0;

    }



    // Констркутор в одну строку

    Water(String name, double volume, double temp){

        this.name = name;
        this.temp = temp;
        this.volume = volume;

    }



    // Свойства объектов класса Water

    String name;
    double temp, volume;

}