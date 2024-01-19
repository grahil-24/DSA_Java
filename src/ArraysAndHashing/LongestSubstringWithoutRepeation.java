package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeation {

    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int count = 0;
        while(i <= s.length() - 1){
            if (s.charAt(i) == ' ') {
                continue;
            }
            if(map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i)) + 1;
                if(count > res){
                    res = count;
                }
                map.clear();
                count = 0;
            }else{
                map.put(s.charAt(i), i);
                count++;
                i++;
            }
        }
        if(count > res){
            res = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithoutRepeation.lengthOfLongestSubstring("pwwkew"));
    }
}
