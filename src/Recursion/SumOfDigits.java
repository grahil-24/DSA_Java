package Recursion;

public class SumOfDigits {

    static int sumOfDigits(int num){
        if(num < 10){
            return num;
        }
        return sumOfDigits(num/10) * (num % 10);
    }

    public static void main(String[] args) {
        System.out.println(SumOfDigits.sumOfDigits(1342));
    }
}
