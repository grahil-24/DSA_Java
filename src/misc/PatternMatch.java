package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PatternMatch {

    public boolean wordPattern(String pattern, String s) {
        //pattern = "abba"
        //s = "dog cat cat dog"

        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));
        int length = pattern.length();

        Map<Character, String> map = new HashMap<>();

        if(length <= 1){
            return true;
        }

        if(words.length != length){
            return false;
        }
        map.put(pattern.charAt(0), words[0]);
        for(int i=1; i<length; i++){
            if(map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)).equals(words[i])){
                continue;
            }else if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }else if(!map.containsKey(pattern.charAt(i)) && map.containsValue(words[i])){
                return false;
            }else{
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PatternMatch pm = new PatternMatch();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(pm.wordPattern(pattern, s));

    }
}
