package Sorting;

import java.util.Arrays;

public class InsertionSort{

    public int[] sort(int[] arr){

        int length = arr.length;
        // [5, 6, 7, 1, 2, 3]
        for(int i = 1; i<length; i++){
            int j = i;
            while(j>0){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }else{
                    break;
                }

            }
        }
        return arr;
    }



    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {0,0, 5,4, 3, 2, 1, 3};
        System.out.println(Arrays.toString(is.sort(arr)));
    }
}
