import java.lang.String;

public class NewBeer{

    static BeerCalc Calc = new BeerCalc();

    static BeerCalc[] C = new BeerCalc[10];

    public static void main (String[] args){

        Calc.addElement("Company1", "Name1", "1", "30");
        Calc.addElement("Company2", "Name2", "1.5", "950");

        Calc.addElement("Company1", "Name1", "Pellet", "10", "14.9" ,"90");
        Calc.addElement("Company1", "Name1", "Pellet", "20", "14.9" ,"60");
        Calc.addElement(20, 1.055, 1.005);

        Calc.mathsBeer();

        System.out.println("Объём воды по умолчанию: " + Calc.obiom +  " л.");
        System.out.println("IBU: " + Calc.IBU);
        System.out.println("Содержание алкоголя: " + Calc.Alkch + "%");



    }
}