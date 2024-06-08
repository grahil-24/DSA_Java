package Recursion;

public class Count {


    public static void recursiveCount(int n){
        if(n == 0){
            return;
        }
        n = n-1;
        recursiveCount(n);

        System.out.println(n);
    }

    public static void main(String[] args) {
        Count.recursiveCount(5);
    }

}
