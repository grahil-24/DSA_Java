package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        helper(nums, 0, nums.length-1 ,res, perm);
        return res;
    }

    public void helper(int[] nums, int l, int r,List<List<Integer>> res, List<Integer> perm){
        if(l > r){
            List<Integer> list = new ArrayList<>();
            for(int i: nums){
                list.add(i);
            }
            res.add(list);
            return;
        }

        for(int i=l; i <= r; i++){
            swap(l, i, nums);
            helper(nums, l+1, r, res, perm);
            swap(l, i, nums);
        }
    }

    public void swap(int l, int r, int[] nums){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }



    public static void main(String[] args) {
        Permutations perm = new Permutations();
        System.out.println(perm.permute(new int[]{1, 2, 3}));
    }
}
