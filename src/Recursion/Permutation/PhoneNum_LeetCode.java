package Recursion.Permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNum_LeetCode {
    private static Map<Character, String> digitToLetters = new HashMap<>();
    static{
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }
    static List<String> pad(String p, String up){
        if(up.isEmpty()){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> res2 = new ArrayList<>();
        String mappedString = digitToLetters.get(up.charAt(0));
        int length = mappedString.length();
        for(int i =0; i<length; i++){
            res2.addAll(pad(p+mappedString.charAt(i), up.substring(1)));
        }
        return res2;
    }


    public static void main(String[] args) {
        System.out.println(PhoneNum_LeetCode.pad("", ""));
    }

}
