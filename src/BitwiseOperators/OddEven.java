package BitwiseOperators;

public class OddEven {

    private static  boolean oddEven(int num){
        return (num & 1) == 1;
    }


    public static void main(String[] args) {
        System.out.println(OddEven.oddEven(0));
    }
}
