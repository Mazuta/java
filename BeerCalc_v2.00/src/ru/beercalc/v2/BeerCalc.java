package ru.beercalc.v2;

/**
 * Класс BeerCalc
 *
 * Описание, предназначение:
 *
 * Пока готовится
 *
 *
 *
 * Параметры объекта BeerCalc:
 *
 *          malt[] - массив объектов типа Malt (см. описание класса Malt)
 *
 *
 *
 * Описание методов класса BeerCalc:
 *
 *          addMalt(providerName, productName, weight, colorEBC) - добавляет в объект-калькулятор тива BeerCalc объект
 *                  типа Malt с параметрами, указанными в скобках (подробнее о параметрах смотри в описание класса Malt)
 */



public class BeerCalc {



    // Объявление переменных

    Malt[] malt = new Malt[0];



    // Добавление нового солода для расчётов

    public void addMalt(String providerName, String productName, double weight, int colorEBC){



        /* Создайм временный массив объектов tempSolod для преобразования основного массива объектов
        (добавления строки вконей основного массива) */

        Malt[] tempMalt = new Malt[malt.length];



        // Инициализируем все члены временного массива

        for (int i = 0; i < tempMalt.length; i++){tempMalt[i] = new Malt();}



        // Перегоняем все элементы основного массива solod во временный tempSolod

        for (int i = 0; i < malt.length; i++){

            tempMalt[i].providerName = this.malt[i].providerName;
            tempMalt[i].productName = this.malt[i].productName;
            tempMalt[i].weight = this.malt[i].weight;
            tempMalt[i].colorEBC = this.malt[i].colorEBC;

        }



        /* Пересозлаём массив объектов solod с количеством членов на 1 больше чем во временном массива tempSolod,
        инициализируем все его члены и присваемаем им значения из временного массива */

        this.malt = new Malt[tempMalt.length + 1];

        for (int i = 0; i < tempMalt.length; i++){

            this.malt[i] = new Malt(tempMalt[i].providerName, tempMalt[i].productName, tempMalt[i].weight, tempMalt[i].colorEBC);

        }



        // Добавление новой строки в массив объектов solod

        this.malt[malt.length - 1] = new Malt(providerName, productName, weight, colorEBC);



        // Удаление ссылки на массив временных объектов tempSolod

        tempMalt = null;

    }

    public static void main(String[] args){
        // тестирование метода addMalt

        BeerCalc calc = new BeerCalc();

        System.out.println(calc.malt.length);
        System.out.println("добавляем одну строку");
        calc.addMalt("Поставщик 1","Продукт 1", 1, 10);
        System.out.println(calc.malt.length);
        System.out.println("добавляем вторую строку");
        calc.addMalt("Поставщик 2","Продукт 2", 2, 20);
        System.out.println(calc.malt.length);
        System.out.println("добавляем третью строку");
        calc.addMalt("Поставщик 3","Продукт 3", 3, 30);
        System.out.println(calc.malt.length);
        System.out.println("Вывод всех добавленных солодов");
        System.out.println(calc.malt[0].providerName + " " + calc.malt[0].productName + " " + calc.malt[0].weight + " " + calc.malt[0].colorEBC);
        System.out.println(calc.malt[1].providerName + " " + calc.malt[1].productName + " " + calc.malt[1].weight + " " + calc.malt[1].colorEBC);
        System.out.println(calc.malt[2].providerName + " " + calc.malt[2].productName + " " + calc.malt[2].weight + " " + calc.malt[2].colorEBC);
    }
}
