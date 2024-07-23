package TwoDimDP;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        Map<String,Boolean> memo = new HashMap<>();
        if(s1.length()  + s2.length() != s3.length()){
            return false;
        }

        return helper(0, 0, 0, s1,s2, s3, memo);

    }

    public boolean helper(int s1_index, int s2_index, int s3_index, String s1 , String s2, String s3, Map<String, Boolean> memo){
        String s = s1_index + "," + s2_index + "," + s3_index;
        if(s3_index == s3.length()){
            return true;
        }
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        boolean res = false;
        if(s1_index < s1.length() && s2_index < s2.length() && s1.charAt(s1_index) == s3.charAt(s3_index) && s3.charAt(s3_index)== s2.charAt(s2_index)){
            res =  helper(s1_index+1, s2_index, s3_index+1, s1, s2, s3, memo);
            if(!res){
                res = helper(s1_index, s2_index+1, s3_index+1, s1, s2, s3, memo);
            }
        }else if( s1_index < s1.length() && s1.charAt(s1_index) == s3.charAt(s3_index) ){
            res =  helper(s1_index+1, s2_index, s3_index + 1, s1, s2 ,s3, memo);
        }else if(s2_index < s2.length() && s2.charAt(s2_index) == s3.charAt(s3_index) ){
            res =  helper(s1_index, s2_index+1, s3_index + 1, s1, s2, s3, memo);
        }
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("", "", ""));
    }
}
