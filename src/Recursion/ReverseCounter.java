package Recursion;

public class ReverseCounter {


    static void printCounter(int n){

        if(n == 0){
            return;
        }
        System.out.println(n);
        printCounter(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        ReverseCounter.printCounter(5);
    }
}
