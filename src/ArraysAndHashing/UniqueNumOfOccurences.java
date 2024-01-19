package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumOfOccurences {

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> num_count = new HashMap<>();
        Set<Integer> freq_count = new HashSet<>();

        for(int num: arr){
            if(num_count.containsKey(num)){
                int val = num_count.get(num);
                num_count.put(num, ++val);
            }else{
                num_count.put(num, 1);
            }
        }

        for(int i: num_count.keySet()){
            int freq = num_count.get(i);
            if(freq_count.contains(freq)){
                return false;
            }else{
                freq_count.add(freq);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(UniqueNumOfOccurences.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
