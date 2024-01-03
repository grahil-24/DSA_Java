package Sorting;

import java.util.Arrays;

public class SelectionSort {

    //worst case: O(n^2)
    //best case:  O(n^2)

    //performs well on small lists/arrays.
    public int[] sort(int[] arr){
        int length = arr.length;
//        int min = arr[0];
//        int minIndex = 0;
        int i, j;
        if(length == 1){
            return arr;
        }

        for(i = 0; i< length-1; i++){         //{5, 6,4, 3, 8};
            int min = arr[i];
            int minIndex = i;
            for(j=i; j<length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            System.out.println(min);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        SelectionSort ss= new SelectionSort();
        int[] arr = {6, 5, 4, 3, 2};
        System.out.println(Arrays.toString(ss.sort(arr)));


    }
}
