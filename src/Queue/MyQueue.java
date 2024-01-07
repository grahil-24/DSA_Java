package Queue;

import Stack.MyStack;

public class MyQueue {

    private int[] data;
    static final int DEFAULT_SIZE = 5;

    private int end = 0;

    public MyQueue(){
        this(DEFAULT_SIZE);
    }

    public MyQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == this.data.length;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public void enqueue(int num) throws Exception{
        if(isFull()){
            throw new Exception("Queue is already full!");
        }
        data[end++] = num;
    }

    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is already empty!");
        }
        int num = data[0];
        if(end == 1){
            end--;
        }else{
            for(int i =1; i<end; i++){
                data[i-1] = data[i];
            }
            end--;
        }
        return num;
    }

    public void display(){
        for(int i=0; i<end; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue  = new MyQueue();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.display();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.display();
    }
}
