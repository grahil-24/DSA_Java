package Queue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> queue;

    public QueueUsingStack(){
        queue = new Stack<>();
    }

    public void push(int x){
        if(queue.empty()){
            queue.push(x);
        }else{
            Stack<Integer> temp = new Stack<>();
            while(!queue.empty()){
                temp.push(queue.pop());
            }
            temp.push(x);
            while(!temp.empty()){
                queue.push(temp.pop());
            }
        }
    }

    public Integer pop(){
        if(queue.empty()){
            return null;
        }
        return queue.pop();
    }

    public Integer peek(){
        if(queue.empty()){
            return null;
        }
        return queue.peek();
    }

    public static void main(String[] args) {
    }
}
