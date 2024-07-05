package Greedy;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];

        helper(0, dp, nums);

        return dp[0] == 1;

    }


    public void helper(int index, int[] dp, int[] num){
        if(dp[index] != 0) return;
    }


    public static void main(String[] args) {

    }

}
