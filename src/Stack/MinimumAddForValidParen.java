package Stack;

import java.util.Stack;

public class MinimumAddForValidParen {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.empty()){
                    count++;
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.empty()){
            stack.pop();
            count++;
        }

        return count;
    }

}
