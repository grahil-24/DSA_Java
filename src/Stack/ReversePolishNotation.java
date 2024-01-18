package Stack;

import java.sql.SQLOutput;
import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        int res = 1;
        boolean firstExpr = true;
        Stack<Integer> stack = new Stack<>();

        for(String str: tokens){
            if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")){
                int var1 = stack.pop();
                int var2 = stack.pop();
                res = switch (str) {
                    case "+" ->
                        // Code for addition
                            var2 + var1;
                    case "-" ->
                        // Code for subtraction
                            var2 - var1;
                    case "*" ->
                        // Code for multiplication
                            var2 * var1;
                    case "/" ->
                        // Code for division
                            var2 / var1;
                    default -> res;
                };
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(ReversePolishNotation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
