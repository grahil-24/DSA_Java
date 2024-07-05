package AdvancedGraphs;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
       int n = nums.length;
       int target_sum  = (n * (n + 1)) / 2;
       int sum = 0;
       for (int i = 0; i < n; i++) {
           sum += nums[i];
       }
       return target_sum - sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{0, 1}));
    }
}
