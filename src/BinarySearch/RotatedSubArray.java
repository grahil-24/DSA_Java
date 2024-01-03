package BinarySearch;

public class RotatedSubArray {

    public static int binSearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
                return mid;
            }else{
                int res1 = binSearch(arr,  target, start, mid-1);
                int res2 = binSearch(arr, target, mid+1, end);
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target){
        int res = binSearch(nums, target, 0 , nums.length-1);

        return res;
    }


    public static void main(String[] args) {
            int[] arr = {4, 5, 6, 7, 0, 1, 2};
            int target = 6 ;
            int res = search(arr, target);
            System.out.println(res);
    }
}
