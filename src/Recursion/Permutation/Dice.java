package Recursion.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {

    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=6 && i<= target; i++){

            dice(p + i, target -i);
        }
    }


    public static void main(String[] args) {
        Integer[] candidates = {2,3,6,7};
        List<List<Integer>> res = Dice.dice(Arrays.asList(candidates), 7);
        System.out.println(res);
    }

    static List<List<Integer>> dice(List<Integer> res, int target){
        if(target == 0){
            List<List<Integer>> res0 = new ArrayList<>();
            res0.add(res);
            return res0;
        }
        List<List<Integer>> res2 = new ArrayList<>();
        for(int i=1; i<=6 && i<= target; i++){
            List<Integer> res3 = new ArrayList<>();
            res2.addAll(dice(res3, target -i));
        }
        return res2;
    }
}
