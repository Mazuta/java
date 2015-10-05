package ru.beercalc.v2;

/**
 * Hops - хмель.
 *
 *
 *
 * Данный класс описывает семейство объектов ХМЕЛЬ и их основными параметрами:
 *
 *         providerName - название компании поставщика (Пример: Yakima Chief), поумолчанию null;
 *
 *         productName - название хмеля (Пример: AMARILLO), поумолчанию null;
 *
 *         weight - вес в г (Пример: 5 г), поумолчанию 0;
 *
 *         alpha - a - кислота в % (Пример: 9.2), поумолчанию 0;
 *
 *         kindPellet - характеризует тип хмеля, по умолчагию false;
 *              kindPellet = false - для шишкового хмеля;
 *              kindPellet = true - для гранулированного хмеля;
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
 *         Hops xmel = new Hops();
 *
 *              xmel.providerName = "Yakima Chief";
 *              xmel.productName = "AMARILLO";
 *              xmel.weight = 10;
 *              xmel.alpha = 9.2;
 *              kindPellet = true;
 *
 * Пример 2:
 *
 *         Hops xmel = new Hops("Yakima Chief", "AMARILLO", 10, 9.2, true);
 */


public class Hops {



    // Конструктор по умолчанию

    Hops(){
        this.providerName = null;
        this.productName = null;
        this.weight = 0;
        this.alpha = 0;
        this.kindPellet = false;

    }



    // Констркутор в одну строку

    Hops(String providerName, String productName, double weight, double alpha, boolean kindPellet){

        this.providerName = providerName;
        this.productName = productName;
        this.weight = weight;
        this.alpha = alpha;
        this.kindPellet = kindPellet;

    }



    // Свойства объектов класса Hops

    String providerName, productName;
    double weight, alpha;
    boolean kindPellet;

}