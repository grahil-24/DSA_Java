package Recursion;

import java.util.Arrays;

public class MergeSort_2 {


    static void mergeSort(int[] arr, int start, int end){
        if(start == end){
            return;
        }
        int mid = start + (end - start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end){
        int[] mergedArray = new int[end - start + 1];
        int leftPointer = start;
        int rightPointer = mid+1;
        int k=0;

        while(leftPointer <= mid && rightPointer <= end){
            if(arr[leftPointer] < arr[rightPointer]){
                mergedArray[k] = arr[leftPointer];
                leftPointer++;
            }else{
                mergedArray[k] = arr[rightPointer];
                rightPointer++;
            }
            k++;
        }

        while(leftPointer <=mid){
            mergedArray[k] = arr[leftPointer];
            leftPointer++;
            k++;
        }
        while(rightPointer <= end){
            mergedArray[k] = arr[rightPointer];
            rightPointer++;
            k++;
        }
        for(int i: mergedArray){
            arr[start] = i;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 0, 1, 10};
        MergeSort_2.mergeSort(arr, 0, arr.length-1);
    }
}
