/*
* Описание структуры запуска
*
*       CalcIBU [объем сусла после кипечения] [плотность сусла] [вид хмеля: Wh - шишки, Ph - гранулы]
*                   [вес хмеля в грамах] [ кислотность ALPHA %] [время варки в минутах]
*
* */

import java.lang.Float;
import java.lang.Integer;
import java.lang.Math;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CalcIBU{

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

            //Расчёт утилизации хмеля

            Utilisacia_hmelia = (1.65 * Math.pow(0.000125,Plotnost_susla - 1)) * ((1 - Math.exp(-0.04 * Vremia_varki)) / 4.15);

            //Коррекция значения утилизации для типа хмеля (W - шишковой, P - гранулированный)
            if (Tip_hvelia.equals(Ph)){
                Utilisacia_hmelia = Utilisacia_hmelia * 1.1;
            }

            //Расчёт IBU

            IBU = Utilisacia_hmelia * (((Alpha_hmelia / 100) * (Ves_hmelia * 0.0352739619) * 7490) / (Obem_susla * 0.264172052));
            //Округлкние до 0.00
            IBU = IBU * 100;
            IBU = Math.round(IBU);
            IBU = IBU / 100;

            //Вывод IBU на экран

            System.out.println("IBU: " + IBU);

        }else{

            //Вывод справки если параметры не указаны
            System.out.println("error");
        }

    }

}