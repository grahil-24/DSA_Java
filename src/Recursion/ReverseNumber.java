package Recursion;

public class ReverseNumber {


    public static int revNum(int n){
        if(n < 10){
            return n;
        }

        return revNum(n % 10) * 10;
    }

}
