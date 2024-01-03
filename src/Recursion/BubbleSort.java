package Recursion;

public class BubbleSort {


    static void bubbleSort(int[] arr, int s, int e){
        if(s == 0){
            return;
        }

        if(e<s){
            if(arr[e] > arr[e+1]){
                int temp = arr[e+1];
                arr[e+1] = arr[e];
                arr[e] = temp;
                bubbleSort(arr, s, e+1);
            }else{
                bubbleSort(arr, s, e+1);
            }
        }else{
            bubbleSort(arr, s-1, 0);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2,3, 4, 5};
        BubbleSort.bubbleSort(arr, arr.length-1, 0);
    }
}
