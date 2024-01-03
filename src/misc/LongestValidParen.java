package misc;

import java.util.Stack;

public class LongestValidParen {


    public int longestValidParentheses(String s) {
         Stack<Character> stack = new Stack<>();
         int length = s.length();
         boolean valid = true;
         int count = 0;
         int maxCount = 0;
         for(int i =0; i<length; i++){
             if(s.charAt(i) == '('){
                 stack.push('(');
             }else if(s.charAt(i) == ')'){
                 if(stack.isEmpty()){
                     if(count > maxCount){
                         maxCount = count;
                     }
                     count  = 0;
                 }else{
                     stack.pop();
                     count+=2;
                 }
             }
         }
         if(count > maxCount){
            maxCount = count;
         }
         return maxCount;
    }

    public static void main(String[] args) {
        LongestValidParen lvp = new LongestValidParen();
        String s = "()(()";
        System.out.println(lvp.longestValidParentheses(s));
    }
}
