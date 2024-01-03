package BinarySearch;

public class BinarySearch {

    public static int search(int[] arr, int element){
        int high=arr.length-1;
        int low=0;
        boolean asc = arr[low] <= arr[high];
    //for ascending order arrays
        while(low <= high){
            int mid = (high + low)/2;
            if(arr[mid] > element){
                if(asc) {
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(arr[mid] < element){
                if(asc) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int target= 2;

        int value = search(arr, target);
        if(value == -1){
            System.out.println("Element not found in the array");
        }else{
            System.out.println("Element found at the index "+value);
        }
    }

}
