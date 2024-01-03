package Recursion;

public class SelectionSort {

    static void selectionSort(int[] arr, int row, int col, int max){
        if(row == 0){
            return;
        }

        if(col > row){
            int temp = arr[max];
            arr[max] = arr[row];
            arr[row] = temp;
            selectionSort(arr, row-1, 0, 0);
        }else{
            if(arr[col]> arr[max]){
                max = col;
            }
            selectionSort(arr, row, col+1, max);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 7,4,4, 3, 10, 1, 0};
        SelectionSort.selectionSort(arr, arr.length-1, 0, 0);
    }
}
