package Recursion;

public class CheckIfSorted {

    static boolean checkIfSorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }

        return (arr[index] < arr[index+1]) && checkIfSorted(arr, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(CheckIfSorted.checkIfSorted(arr, 0));
    }
}
