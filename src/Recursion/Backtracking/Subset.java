package Recursion.Backtracking;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(res, subset, nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> subset, int[] nums, int index){
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        helper(res, subset, nums, index+1);
        subset.removeLast();
        helper(res, subset, nums, index+1);
    }

    public static void main(String[] args) {
        Subset s = new Subset();
        System.out.println(s.subsets(new int[]{1, 2, 3}));

    }

}

