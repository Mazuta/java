public class Test {

    public static void main(String[] args){

        Sam[] s = new Sam[1];
            s[0] = new Sam();

        s[0].name = "Максимус";

        System.out.println(s[0].name);

    }

    public static class Sam{
        public String name;
    }


}
