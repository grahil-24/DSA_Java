package DP;

public class PartitionEqualSubset {

    public boolean canPartition(int[] nums) {
//        Math.max();
        int sum = 0;

        for(int num : nums){
            sum += num;
        }
        if(sum == 0){
            return true;
        }
        if(sum % 2 != 0){
            return false;
        }
        return helper(sum/2, nums);
    }

    public boolean helper(int target, int[] nums){
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num: nums){
            for(int i = target; i >= num; i--){
                if(dp[i - num]){
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubset pes = new PartitionEqualSubset();
        System.out.println(pes.canPartition(new int[]{1,2,3,5}));
    }
}
