package Recursion;

public class FibonacciSeq {

    private int num1 = 0;
    private int num2 = 1;


    public int printFibSeq(int n){
        if(n < 2){
            return n;
        }
        return printFibSeq(n-1) + printFibSeq(n-2);
    }

    public static void main(String[] args) {

        FibonacciSeq fs = new FibonacciSeq();
        System.out.println(fs.printFibSeq(8));


    }
}
