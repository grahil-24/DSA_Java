package Recursion;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e - s)/2;
        int pivot = arr[mid];

        while(s<=e){
            while(arr[s] <pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = arr[e];
                arr[e] = arr[s];
                arr[s] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);

    }


    public static void main(String[] args) {
        int[] arr = {5 , 4, 3, 2, 1};
        QuickSort.quickSort(arr,  0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
