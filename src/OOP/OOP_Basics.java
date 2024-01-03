package OOP;

public class OOP_Basics {


    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        swap(a, b);
        System.out.println(a + " " + b);
    }

    static void swap(String a, String b){
        String temp = a;
        a = b;
        b = temp;
    }
}
