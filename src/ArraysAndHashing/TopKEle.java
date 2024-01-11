package ArraysAndHashing;

import java.util.*;

public class TopKEle {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] freq = new int[nums.length+1];
        int[] ans = new int[k];
        for(int i: nums){
            if(map.containsKey(i)){
                int val = map.get(i);
                map.put(i, ++val);
            }else{
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>(Collections.nCopies(map.size()+1, 0));
        for(int key: map.keySet()){
            list.set(map.get(key), key);
        }
        int k_t = k;
        int len = list.size();
        int count=0;
        for(int i=len-1; i>=0; i-- ){
            if(count == k){
                break;
            }
            ans[--k_t] = list.get(i);
            count++;
        }

        return ans;
    }

    public static void main(String[] args) {
        TopKEle.topKFrequent(new int[]{-1, -1}, 1);
    }
}
