package Recursion;

import java.util.Arrays;

public class MergeSort {

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length /2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] mergedArray = new int[left.length+right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int k=0;

        while(leftPointer < left.length && rightPointer < right.length ){
            if(left[leftPointer] < right[rightPointer]){
                mergedArray[k] = left[leftPointer];
                leftPointer++;
            }else{
                mergedArray[k] = right[rightPointer];
                rightPointer++;
            }
            k++;
        }

        while(leftPointer < left.length){
            mergedArray[k] = left[leftPointer];
            leftPointer++;
            k++;
        }
        while(rightPointer < right.length){
            mergedArray[k] = right[rightPointer];
            rightPointer++;
            k++;
        }
        return mergedArray;
    }


    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};
        int[] arr2 = MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
