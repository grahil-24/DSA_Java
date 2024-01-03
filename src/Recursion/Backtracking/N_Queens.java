package Recursion.Backtracking;

import java.util.Arrays;

public class N_Queens {

    static int printSolution(int[][] matrix, int r){
        if(r==matrix.length){
            for(int[] row: matrix){
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            return 1;
        }
        int count = 0;
       for(int col = 0; col<matrix.length; col++){
           if(checkIfBlocked(matrix, r, col)){
                matrix[r][col] = 1;
                count = count + printSolution(matrix, r+1);
                matrix[r][col] = 0;
           }
       }
       return count;
    }

    static boolean checkIfBlocked(int[][]matrix, int r, int c){
        //upper rows
        for(int i = r; i>=0; i--){
            if(matrix[i][c] == 1){
                return false;
            }
        }
        //left diagonal
        int j = r;
        for(int i = c; i>=0 && j>=0; i--){
            if(matrix[j][i] ==1){
                return false;
            }
            j--;
        }
        j= r;
        //right diagonal
        for(int i= c; i<matrix[0].length && j>=0; i++){
            if(matrix[j][i] ==1){
                return false;
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
            int[][] matrix = new int[8][8];
            for(int[] arr: matrix){
                Arrays.fill(arr, 0);
            }
            int res =printSolution(matrix, 0);
        System.out.println(res);
    }
}
