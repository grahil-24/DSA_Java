package Recursion;

public class PassingNumber {

    //first passed then subtracted
    static void fun1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun1(n--);
    }

    static void fun2(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun2(--n);
    }

    public static void main(String[] args) {
        PassingNumber.fun1(5);
        PassingNumber.fun2(5);
    }
}
