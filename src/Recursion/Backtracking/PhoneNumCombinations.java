package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumCombinations {

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

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }

        helper(digits, new StringBuilder(), 0, res);
        return res;
    }

    public void helper(String digits, StringBuilder str, int index, List<String> res){
        if(index >= digits.length()){
            res.add(str.toString());
            return;
        }
        String st = digitToLetters.get(digits.charAt(index));
        for(int i = 0; i<st.length(); i++){
            str.append(st.charAt(i));
            helper(digits, str, index+1, res);
            str.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        PhoneNumCombinations pnc = new PhoneNumCombinations();
        System.out.println(pnc.letterCombinations("23"));
    }


}
