package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, nums,0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(index >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(res, list, nums, index+1);
        list.removeLast();

        while(index < nums.length-1 && nums[index] == nums[index+1]){
            index+=1;
        }
        helper(res, list, nums, index+1);
    }

    public static void main(String[] args) {
        Subset2 s2 = new Subset2();
        int[] arr = {1, 2, 2, 3};
        System.out.println(s2.subsetsWithDup(arr));

    }
}
