package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(candidates, res, subset, 0, target);
        return res;
    }

    public void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> subset, int index, int target){
        if(target < 0 || index >= candidates.length){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(candidates[index]);
        backtrack(candidates, res, subset, index, target-candidates[index]);
        subset.removeLast();
        backtrack(candidates, res, subset, index+1, target);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2, 3, 5}, 8)
        );
    }
}
