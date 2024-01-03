package Recursion;

public class TrianglePattern {


    static void printPattern(int rows, int columns){
        if(rows == 0){
            return;
        }
        if(columns < rows){
            System.out.print("*");
            printPattern(rows, columns+1);
        }else{
            System.out.println();
            printPattern(rows-1, 0);
        }

    }
    static void printPattern2(int rows, int columns){
        if(rows == 0){
            return;
        }
        if(columns < rows){
            printPattern2(rows, columns+1);
            System.out.print("*");

        }else{
            printPattern2(rows-1, 0);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        TrianglePattern.printPattern(5, 0);
    }
}
