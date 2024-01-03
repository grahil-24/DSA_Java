package BinarySearch;

import java.util.*;

public class MajorityEle {

    private static HashMap<Integer, Integer> numCount = new HashMap<>();
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> answer = new ArrayList<>();
        int repetitions = nums.length/3;
        System.out.println(repetitions);
        for(int i: nums){
            Integer count = numCount.get(i);
            if(count == null){
                numCount.put(i, 1);
            }else{
                numCount.put(i, count+1);
            }

        }

        for (HashMap.Entry<Integer, Integer> entry : numCount.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > repetitions){
                answer.add(key);
            }
        }

        return answer;
}

    public static void main(String[] args) {

        int[] nums = {1, 2};

        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);





    }
}
