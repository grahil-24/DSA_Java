package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str: strs){
            List<Integer> count = new ArrayList<>(Collections.nCopies(26, 0));
            for(char ch: str.toCharArray()){
                int index = ch - 'a';
                int val = count.get(index);
                count.set(index, ++val);
            }
            if(map.containsKey(count)){
                List<String> val = map.get(count);
                val.add(str);
                map.put(count, val);
            }else{
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(count, tmp);
            }
        }
        for(List<Integer> count: map.keySet()){
            ans.add( map.get(count));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> res =GroupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(res);
    }
}
