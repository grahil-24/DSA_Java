package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int length = 1;
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        for(int i: set){
            int c = 1;
            if(set.contains(i-1)){
                continue;
            }
            while(set.contains(i+1)){
                c++;
                i++;
            }
            if(c > length){
                length = c;
            }
            c = 1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
