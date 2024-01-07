package Queue;

import java.util.concurrent.ExecutionException;

public class CircularQueue {

     int[] data;

    int size = 0;
    int start = 0;
    int end = 0;

    int length=0;

    private static final int DEFAULT_SIZE = 5;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        data = new int[size];
        this.length = size;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int num) throws Exception{
        if(isFull()){
            throw new Exception("Queue already full!");
        }
        data[end] = num;
        end = (end + 1)% length;
        size++;
    }

    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is already empty!");
        }
        int num = data[start];
        start = (start + 1)%length;
        size--;
        return num;
    }

    public void display(){
        if(size == 0){
            System.out.println("Empty Queue!");
        }else if(end >= start){
            for(int i = 0; i<size; i++){
                System.out.print(data[(start+i)%length] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue();
        cq.enqueue(5);
        cq.enqueue(4);
        cq.enqueue(3);
        cq.enqueue(2);
        cq.enqueue(1);
        cq.display();
        cq.dequeue();
        cq.enqueue(6);
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.display();

    }
}
