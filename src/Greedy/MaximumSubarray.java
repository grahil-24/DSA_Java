package Greedy;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
           int sum = nums[i];
           int j;
           for(j = i+1; j < nums.length; j++){
               if( sum > res){
                   res = sum;
               }
               sum += nums[j];
               if(nums[j] > sum){
                   i = j-1;
                   break;
               }
           }
            if( sum > res){
                res = sum;
            }
            i = j-1;
        }

        return res;
    }

    public static void main(String[] args) {

        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
