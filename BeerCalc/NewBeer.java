import java.lang.String;

public class NewBeer{

    static BeerCalc Calc = new BeerCalc();

    public static void main (String[] args){

        Calc.addElement("Company1", "Name1", "Pellet", "10", "14.9" ,"90");
        Calc.addElement("Company1", "Name1", "Pellet", "20", "14.9" ,"60");
        Calc.addElement(20, 1.055, 1.005);

        Calc.mathsBeer();

        System.out.println(Calc.IBU);



    }
}