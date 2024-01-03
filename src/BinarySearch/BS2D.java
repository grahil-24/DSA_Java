package BinarySearch;

public class BS2D {

    public boolean searchMatrix(int[][]  matrix, int target){
        int rows = matrix.length;
        int start = 0;
        int end = rows - 1;
        int mid = 0;

        while(start <= end){
            mid = start + (end - start)/2;
            if(matrix[mid][0] > target) {
                end = mid - 1;
            }else if(matrix[mid][0] < target){
                start = mid + 1;
            }else{
                return true;
            }
        }
        if(end == -1){
            return searchRow(matrix, target, 0);
        }else{
            return searchRow(matrix, target, end);
        }
    }

    public boolean searchRow(int[][] matrix, int target, int row){
        int columns = matrix[row].length;
        System.out.println(columns);
        int end = columns - 1;
        int start = 0;
        System.out.println(row);
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid] < target){
                start = mid + 1;
            }else if(matrix[row][mid] > target){
                end = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        BS2D bs = new BS2D();
        int[][] arr = {{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(bs.searchMatrix(arr, 30));
    }
}
