package Recursion;

public class BinarySearch {


    static int search(int[] arr, int start, int end, int target){

        if(start > end){
            return -1;
        }
        int middle = start + (end - start)/2;
        if(arr[middle] == target){
            return  middle;
        }
        if(arr[middle] > target){
            return search(arr, start, middle - 1, target);
        }
        return search(arr, middle+1, end, target);
    }

    public static void main(String[] args) {

        int[]arr = {1, 2, 3, 4, 5};
        System.out.println(BinarySearch.search(arr, 0, 4, 4));

    }
}
