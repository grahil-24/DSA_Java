package BinarySearch;

import java.util.Arrays;

public class TwoDimArray {

    public int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row, col};
            }

            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoDimArray tda = new TwoDimArray();
        int[][] arr  = {{1,3}};

        System.out.println(Arrays.toString(tda.search(arr, 3)));
    }
}
