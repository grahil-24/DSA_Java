package OOP.ExceptionHandling;

import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            divide(a, b);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Bruh!");
        }

    }

    static int divide(int a, int b) throws MyException{
        if(b==0){
            throw new MyException("Cant divide by 0");
        }
        return a /b;
    }

}
