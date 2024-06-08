package Recursion.Backtracking;

import misc.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        helper(res, 0, s, partition);
        return res;
    }

    public void helper(List<List<String>> res, int index, String s, List<String> part){
        if(index >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                part.add(s.substring(index, i+1));
                helper(res, i+1,s, part);
                part.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        if(i == j){
            return true;
        }
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromPartition pp = new PalindromPartition();
        System.out.println(pp.partition("aab"));
    }
}
