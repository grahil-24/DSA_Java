package Stack;

import java.util.ArrayList;

public class MyStack {

    int ptr = -1;
    int[] data;

    private static final int DEFAULT_SIZE = 10;

    public MyStack(){
        this(DEFAULT_SIZE);
    }

    public MyStack(int size){
        this.data = new int[size];
    }

    public void push(int num) throws StackException{
        if(isFull()){
            throw new StackException("Stack if full!");
        }
        ptr++;
        data[ptr] = num;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw  new StackException("Stack is empty!");
        }
        int num = data[ptr];
        ptr--;
        return num;
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty!");
        }
        return data[ptr];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }

    public static void main(String[] args) throws StackException {
        MyStack stack = new MyStack(5);
//        stack.push(34);
//        stack.push(17);
//        stack.push(19);
//        stack.push(10);
//        stack.push(3);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        MyStack ds = new DynamicStack();
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);
        ds.push(5);

    }
}
