package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoStringsClose {

    public static boolean closeStrings(String word1, String word2) {

        HashMap<Character, Integer> word1_map = new HashMap<>();
        HashMap<Character, Integer> word2_map = new HashMap<>();
        int length1 = word1.length();
        int length2 = word2.length();
        if(length2 != length1){
            return false;
        }
        for(int i = 0; i< length1; i++){
            if(word1_map.containsKey(word1.charAt(i))){
                int val = word1_map.get(word1.charAt(i));
                word1_map.put(word1.charAt(i), ++val);
            }else{
                word1_map.put(word1.charAt(i), 1);
            }
            if(word2_map.containsKey(word2.charAt(i))){
                int val = word2_map.get(word2.charAt(i));
                word2_map.put(word2.charAt(i), ++val);
            }else{
                word2_map.put(word2.charAt(i), 1);
            }
        }

        for(char ch: word1_map.keySet()) {
            if(!word2_map.containsKey(ch)){
                return false;
            }
        }
        for(char ch: word2_map.keySet()) {
            if(!word1_map.containsKey(ch)){
                return false;
            }
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(char ch: word1_map.keySet()){
            int val = word1_map.get(ch);
            if(map1.containsKey(val)){
                int val2 = map1.get(val);
                map1.put(val, ++val2);
            }else{
                map1.put(val, 1);
            }
        }

        for(char ch: word2_map.keySet()){
            int val = word2_map.get(ch);
            if(map2.containsKey(val)){
                int val2 = map2.get(val);
                map2.put(val, ++val2);
            }else{
                map2.put(val, 1);
            }
        }

        for(int val: map1.keySet()){
            if(!map2.containsKey(val)){
                return false;
            }else{
                int val2 = map2.get(val);
                if(map1.get(val) != val2){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(TwoStringsClose.closeStrings("cabbba","abbccc"));
    }
}
