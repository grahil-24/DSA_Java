package TwoDimDP;

import java.util.HashMap;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return memo(nums, 0, 0, target, map);
    }

    public int memo(int[] nums, int index, int sum, int target, HashMap<String, Integer> map){
        String s = STR."\{index},\{sum}";
        if(index == nums.length){
            return (sum == target) ? 1 : 0;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        int res = memo(nums, index + 1, sum + nums[index], target, map) + memo(
                nums, index + 1, sum - nums[index], target, map
        );
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
