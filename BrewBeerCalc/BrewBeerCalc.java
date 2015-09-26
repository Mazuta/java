/*
* Описание структуры запуска
*
*       BrewBeerCalc [объем сусла после кипечения] [плотность сусла] [вид хмеля: Wh - шишки, Ph - гранулы]
*                   [вес хмеля в грамах] [ кислотность ALPHA %] [время варки в минутах]
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

            //Присваивание параметров переменным если параметры указаны

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

            //Расчёт объёма засыпи солода
            Obem_soloda = Obem_susla / 5;

            //Расчёт объёма воды для затирания солода
            Voda_zatirania = Obem_susla * 0.8f * 10;
            Voda_zatirania = Math.round(Voda_zatirania);
            Voda_zatirania = Voda_zatirania / 10;

            //Расчёт объёма воды для промывания
            Voda_promivania = Obem_susla * 0.6f * 10;
            Voda_promivania = Math.round(Voda_promivania);
            Voda_promivania = Voda_promivania / 10;

            //Общий объём воды
            Voda = Voda_zatirania + Voda_promivania;

            //Расчёт утилизации хмеля
            Utilisacia_hmelia = (1.65 * Math.pow(0.000125,Plotnost_susla - 1)) * ((1 - Math.exp(-0.04 * Vremia_varki)) / 4.15);

            //Коррекция значения утилизации для типа хмеля (Wh - шишковой, Ph - гранулированный)
            if (Tip_hvelia.equals(Ph)){
                Utilisacia_hmelia = Utilisacia_hmelia * 1.1;
            }

            //Расчёт IBU
            IBU = Utilisacia_hmelia * (((Alpha_hmelia / 100) * (Ves_hmelia * 0.0352739619) * 7490) / (Obem_susla * 0.264172052));
            //Округлкние до 0.00
            IBU = IBU * 100;
            IBU = Math.round(IBU);
            IBU = IBU / 100;

            //Вывод отчёта о вычислениях на экран
            System.out.println("\n" +
                    "Рецепт, построенный на основе Ваших данных:" +
                    "\n" +
                    "Необходимый общий объем солода: " + Obem_soloda + " кг.\n" +
                    "Для затириния солода нужно использовать " + Voda_zatirania + " л. воды.\n" +
                    "Для промывки дробины нужно использовать " + Voda_promivania + " л. воды.\n" +
                    "Объём котла для варки должен быть больше " + Voda + " л.\n" +
                    "\n" +
                    "Хмель:\n" +
                    "Закладка №1 " + Ves_hmelia + " г. с ALPHA = " + Alpha_hmelia + "% за " + Vremia_varki + " мин. до конца варки.\n" +
                    "Расщётное IBU пива: "+ IBU + " единиц.");
        }else{

            //Вывод справки если параметры не указаны
            System.out.println("Ошибка! Возможно вы ввели некоректные исходные данные пожалуйста ознакомьтись с инструкциец:\n" +
                    "\n" +
                    "BrewBeerCalc [объем сусла после кипечения] [плотность сусла] [вид хмеля: Wh - шишки, Ph - гранулы]\n" +
                    "   [вес хмеля в грамах] [ кислотность ALPHA %] [время варки в минутах]");
        }

    }

}
