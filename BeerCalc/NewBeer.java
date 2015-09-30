import java.lang.String;

public class NewBeer{

    static BeerCalc Calc = new BeerCalc();

    public static void main (String[] args){

        Calc.addElement("Company1", "Name1", "Type1", "Massa1", "Alpha1" ,"TimeV1");

        System.out.println(Calc.hmel[0][0]+Calc.hmel[0][1]+Calc.hmel[0][2]+Calc.hmel[0][3]+Calc.hmel[0][4]+Calc.hmel[0][5]);

        Calc.addElement("Company2", "Name2", "Type2", "Massa2", "Alpha2" ,"TimeV2");

        System.out.println(Calc.hmel[1][0]+Calc.hmel[1][1]+Calc.hmel[1][2]+Calc.hmel[1][3]+Calc.hmel[1][4]+Calc.hmel[1][5]);
    }
}