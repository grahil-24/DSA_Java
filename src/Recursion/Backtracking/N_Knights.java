package Recursion.Backtracking;

import java.util.Arrays;

public class N_Knights {

    static void printSolution(int[][] matrix, int r, int c, int knight){
        if(knight == 0){
            for(int[] row: matrix){
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            return;
        }
        if(r == matrix.length - 1 && c >= matrix.length){
            return;
        }

        if(checkIfBlocked(matrix, r, c)){
            matrix[r][c] = 1;
            if(c == matrix.length -1){
                printSolution(matrix, r+1, 0, knight-1);
                matrix[r][c] = 0;
            }else{
                printSolution(matrix, r, c+1, knight-1);
                matrix[r][c] = 0;
            }
        }else{
            if(c == matrix.length -1){
                printSolution(matrix, r+1, 0, knight);
            }else{
                printSolution(matrix, r, c+1, knight);
            }
        }

    }

    static boolean checkIfBlocked(int[][]matrix, int r, int c){
        //upper rows
        if(c-2>=0 && r-1>=0){
            if(matrix[r-1][c-2] == 1){
                return false;
            }
        }
        if(c-2>=0 && r+1<matrix.length){
            if(matrix[r+1][c-2] == 1){
                return false;
            }
        }
        if(r+2<matrix.length && c-1>=0){
            if(matrix[r+2][c-1] == 1){
                return false;
            }
        }
        if(r+2<matrix.length && c+1 < matrix.length){
            if(matrix[r+2][c+1] == 1){
                return false;
            }
        }
        if(r+1<matrix.length && c+2 < matrix.length){
            if(matrix[r+1][c+2] == 1){
                return false;
            }
        }
        if(r-1 >=0 && c+2 < matrix.length){
            if(matrix[r-1][c+2] == 1){
                return false;
            }
        }

        if(r-2>=0 && c+1 < matrix.length){
            if(matrix[r-2][c+1] == 1){
                return false;
            }
        }

        if(r-2>=0 && c-1>=0){
            if(matrix[r-2][c-1] == 1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
            int[][] matrix = new int[4][4];
            for(int[] arr: matrix){
                Arrays.fill(arr, 0);
            }
            printSolution(matrix, 0, 0, 4);
    }
}
