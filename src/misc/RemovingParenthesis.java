package misc;


import java.util.Stack;

public class RemovingParenthesis {

    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String string = "";
        int length = s.length();
        for(int i=0; i<length; i++){
            if(stack.isEmpty() && s.charAt(i) == '('){
                stack.push('(');
            }else if(s.charAt(i) == '('){
                stack.push('(');
                string = string.concat("(");

            }else if(s.charAt(i) == ')' && stack.size() == 1){
                stack.pop();
            }else{
                stack.pop();
                string = string.concat(")");
            }
        }

        return string;
    }

    public static void main(String[] args) {
        RemovingParenthesis rp = new RemovingParenthesis();
        String s = "(()()())";
        String res = rp.removeOuterParentheses(s);
        System.out.println(res);
    }
}
