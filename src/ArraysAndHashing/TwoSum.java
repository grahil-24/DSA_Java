package ArraysAndHashing;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];

            // Check if complement is already in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Add the current number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found
        return new int[]{-1, -1};

    }

    public static void main(String[] args) {

        TwoSum.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
    }
}
