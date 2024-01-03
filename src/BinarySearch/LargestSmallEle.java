package BinarySearch;

public class LargestSmallEle {

    public int searchInsert(int[] nums, int target) {
        return 0;
    }

    public int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if(target <= nums[0]){
            return 0;
        }
        if(target > nums[end]){
            return end+1;
        }
        if(target == nums[end]){
            return end;
        }
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        LargestSmallEle lse = new LargestSmallEle();
        int[] arr = {1, 10, 23};
        System.out.println(lse.binarySearch(arr, 43));
    }
}
