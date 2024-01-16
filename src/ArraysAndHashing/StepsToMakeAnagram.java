package ArraysAndHashing;

import OOP.Parent;

import java.util.HashMap;
import java.util.Map;

public class StepsToMakeAnagram {

    public static int minSteps(String s, String t) {
        int steps = 0;
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);
            if(s_map.containsKey(s_char)){
                int val = s_map.get(s_char);
                s_map.put(s_char, ++val);
            }else{
                s_map.put(s_char, 1);
            }
            if(t_map.containsKey(t_char)){
                int val = t_map.get(t_char);
                t_map.put(t_char, ++val);
            }else{
                t_map.put(t_char, 1);
            }
        }

        for(char ch: t_map.keySet()){
            int val1 = t_map.get(ch);
            int val2;
            if(!s_map.containsKey(ch)){
                steps += val1;
            }else{
                val2 = s_map.get(ch);
                if(val1 > val2){
                    steps += val1 - val2;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(StepsToMakeAnagram.minSteps("anagram", "mangaar"));
    }
}
