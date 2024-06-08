package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int maxlen = 0;

        for(int i = 0; i<nums.length; i++){
            maxlen = Math.max(maxlen, helper(nums, i,dp));
        }

        return maxlen;
    }

    public int helper(int[] nums, int index, int[] dp){
        if(dp[index] != -1){
            return dp[index];
        }
        //starting subsequence from here
        int maxlen = 1;

        for(int i = index + 1; i<nums.length; i++){
            if(nums[i] > nums[index]){
                maxlen = Math.max(maxlen, helper(nums, i, dp));
            }
        }
        dp[index] = maxlen;
        return maxlen;
    }



    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7}));
    }
}
