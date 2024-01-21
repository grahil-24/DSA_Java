package Stack;

import java.util.LinkedList;
import java.util.Stack;

class Pair{
    int key;
    int val;

    Pair(int key, int val){
        this.key = key;
        this.val = val;
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
            int prevMin = stack.peek().key;
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
        return stack.peek().val;
    }

    public static void main(String[] args) {

    }
}
