package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {


    public static int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i<=length; i++){
            set.add(i);
        }
        for(int num: nums){
            if(!set.contains(num)){
                res[0] = num;
            }else{
                set.remove(num);
            }
        }
        res[1] = set.iterator().next();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SetMismatch.findErrorNums(new int[]{1, 1})));
    }
}
