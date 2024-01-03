package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

//Time complexity:
// Worst Case: O(n^2) when it is sorted but in reverse way
// Best case: O(n^2) already sorted correctly


public class BubbleSort {

    public int[] bubbleSort(int[] arr){
        int length = arr.length;

        if(length == 1){
            return arr;
        }

        // there will be total of length - 1 passes
        int pass = length - 1;

        for(int i = 0; i<pass; i++){
            for(int j = 0; j<length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();
        int[] arr = {-1, 7, -32, 0, 8};
        System.out.println(Arrays.toString(bs.bubbleSort(arr)));
    }
}
