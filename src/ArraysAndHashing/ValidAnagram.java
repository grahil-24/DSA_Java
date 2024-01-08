package ArraysAndHashing;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        AtomicBoolean hasZeroValue = new AtomicBoolean(true);

        int length = s.length();
        for(int i=0; i< length; i++){
            if(map.containsKey(s.charAt(i))){
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i), ++val);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i< length; i++){
            if(map.containsKey(t.charAt(i))){
                int val = map.get(t.charAt(i));
                val--;
                map.put(t.charAt(i), val);
            }else{
                return false;
            }
        }

        map.forEach((key, value)-> {
            if(value != 0){
                hasZeroValue.set(false);
            }
        });
        return hasZeroValue.get();
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        va.isAnagram("anagram", "naagram");
    }
}
