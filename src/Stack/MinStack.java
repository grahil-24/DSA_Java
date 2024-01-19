package Stack;

import java.util.LinkedList;
import java.util.Stack;

class Pair{
    int val;
    int min;

    Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
}

public class MinStack {

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.empty()){
            stack.push(new Pair(val, val));
        }else{
            int prevMin = stack.peek().min;
            if(val < prevMin){
                stack.push(new Pair(val, val));
            }else{
                stack.push(new Pair(val, prevMin));
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    public static void main(String[] args) {

    }
}
