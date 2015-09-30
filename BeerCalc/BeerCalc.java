import java.lang.Double;
import java.lang.String;
import java.nio.IntBuffer;
import java.util.Arrays;

public class BeerCalc {



    //Объявление переменных

    String[][] solod = new String[0][4];    //Массив добавленных солодов
    String[][] hmel = new String[0][6];     //Массив добавленных хмелей
    double start_plotnost = 1.055;          //Начальная плотность сусла до брожения по умолцанию = 1.055 SG
    double finish_plotnost = 1.005;         //Плотность сусла после брожения по умолчанию = 1.005 SG



    //Рассчитываемые параметры полученного пива

    double IBU = 0.00;                      //IBU готового напитка
    double obiom = 0.00;                    //Объём готового напитка (он же объём сусла до и после брожения)
    String color = new String();            //Цвет готового напитка
    double Alkch  = 0.00;                   //Процентное содержание алкоголя в готовом напитке



    //Внутренние переменные

    static int SolodNumber = 0;             //Счётчик строк в массиве солода
    static int HmelNumber = 0;              //Счётчик строк в массиве хмель
    static double Utilisacia_hmelia;        //Уварка хмеля
    static double hmel_type = 1;            //Коэффициент уварки хмеля. Для шишек = 1; для капсул = 1.1



    //Добавление элемента (солода) в рецепт рассчитываемого напитка

    public void addElement(String Company, String Name, String Massa, String Color){



        //Создаем временный массив tempArray с количеством строк на 1 больше массива solod

        String[][] tempArray = new String[solod.length+1][4];



        //Присвоение всех строк массива solod[][] временному массиву tempArray[][]

        for (int i = 0; i < solod.length; i++){
            for(int k = 0; k <= 3; k++){tempArray[i][k]=solod[i][k];}
        }



        //Добавление в последнюю свободную строку значения из переменных

        tempArray[tempArray.length-1][0] = Company;
        tempArray[tempArray.length-1][1] = Name;
        tempArray[tempArray.length-1][2] = Massa;
        tempArray[tempArray.length-1][3] = Color;



        //Переопределениее массива solod[][] сназмарос равным массиву tempArray[][]

        solod = new String[tempArray.length][4];



        //Присвоение всех строк массива tempArray[][] обратно массиву solod[][]

        for (int i = 0; i < tempArray.length; i++) {
            for (int k = 0; k <= 3; k++){solod[i][k] = tempArray[i][k];}
        }
    }



    //Добавление элемента (хмель) в рецепт рассчитываемого напитка

    public void addElement(String Company, String Name, String Type, String Massa, String Alpha ,String TimeV){



        //Создаем временный массив tempArray с количеством строк на 1 больше массива hmel

        String[][] tempArray = new String[hmel.length+1][6];



        //Присвоение всех строк массива hmel[][] временному массиву tempArray[][]

        for (int i = 0; i < hmel.length; i++){
            for(int k = 0; k <= 5; k++){tempArray[i][k]=hmel[i][k];}
        }



        //Добавление в последнюю свободную строку значения из переменных

        tempArray[tempArray.length-1][0] = Company;
        tempArray[tempArray.length-1][1] = Name;
        tempArray[tempArray.length-1][2] = Type;
        tempArray[tempArray.length-1][3] = Massa;
        tempArray[tempArray.length-1][4] = Alpha;
        tempArray[tempArray.length-1][5] = TimeV;



        //Переопределениее массива hmel[][] сназмарос равным массиву tempArray[][]

        hmel = new String[tempArray.length][6];



        //Присвоение всех строк массива tempArray[][] обратно массиву hmel[][]

        for (int i = 0; i < tempArray.length; i++) {
            for (int k = 0; k <= 5; k++){hmel[i][k] = tempArray[i][k];}
        }
    }



    //Добавление параметров сусла до и после брожения в рецепт рассчитываемого напитка

    public boolean addElement(double Obiom, double Plotnost_before, double Plotnost_after){

        this.obiom = Obiom;
        this.start_plotnost = Plotnost_before;
        this.finish_plotnost = Plotnost_after;

        return true;
    }



    //Обнуление параметров калькулятьра

    public void resetCalc(){



        //Осистка массивов solod и hmel (переопределение с нулевым количеством строк)

        this.hmel = new String[0][6];
        this.solod = new String[0][4];



        //Обнуление переменных, учавструющих в расчётах и результатов

        this.start_plotnost = 1.055;
        this.finish_plotnost = 1.005;
        this.IBU = 0d;
        this.obiom = 0.00;
        this.color = "";
        this.Alkch  = 0.00;

    }



    //Расчёт параметров пива

    public void mathsBeer(){



        //Расчёт суммарного значения IBU для всех закладок хмеля

        for (int i = 0; i < hmel.length; i++){

            this.IBU = mathsIBU(i);
        }



        //Определение объёма сусла/пива по умолчанию

        this.obiom = mathsObiom_Default();

    }



    //Расчёт IBU с учётом всех закладок хмеля

    private double mathsIBU(int NumberRow){

        double tempIBU;



        //Определяем уварку хмеля

        this.Utilisacia_hmelia = (1.65 * Math.pow(0.000125,this.start_plotnost - 1)) *
                ((1 - Math.exp(-0.04 * Double.valueOf(this.hmel[NumberRow][5]))) / 4.15);

        switch (this.hmel[NumberRow][2]){

            case "Whole":                           //Если тип хмеля Шишки
                this.hmel_type = 1f;
                break;

            case "Pellet":
                this.hmel_type = 1.1f;              //Если тип хмеля Капсылы
                break;
        }



        //Коррекция значения уварки хмеля в зависимости от типа хмеля

        this.Utilisacia_hmelia *= this.hmel_type;



        //Определение IBU

        tempIBU = this.Utilisacia_hmelia * (((Double.valueOf(this.hmel[NumberRow][4]) / 100) *
                (Double.valueOf(this.hmel[NumberRow][3]) * 0.0352739619) * 7490) / (this.obiom * 0.264172052));

        return roundRes(tempIBU, 100);
    }



    //Округлеие значений

    /*

    Для того стобы округлить значение 0.0000000 до 0.00 необходимо arg =0.0000000, ostatok = 100

     */

    private static double roundRes(double arg, int ostatok){

        double temp;

        temp = arg * ostatok;
        temp = Math.round(temp);
        temp = temp / ostatok;

        return temp;
    }




    //Расчитываем примерный объём напитка по умолчанию (из соотношения солод/вода = 1/5)

    private double mathsObiom_Default(){

        double All_mass_solod = 0;



        //Суммируем массу всех солодов в засыре
        for (int i = 0; i < this.solod.length; i++){All_mass_solod += Double.valueOf(solod[i][2]);}



        //Расчёт воды по соотношению 1/5

        return All_mass_solod * 5;
    }
}