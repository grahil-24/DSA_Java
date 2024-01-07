package Queue;

public class DynamicCircularQueue extends CircularQueue{

    @Override
    public void enqueue(int num) throws Exception{
        if(size == length){
            length = length * 2;
            int[] temp = new int[length];
            for(int i =0; i<size; i++){
                temp[i] = data[(start + i) % size];
            }
            start=0;
            end = size;
            data = temp;
        }
        super.enqueue(num);
    }

    public static void main(String[] args) throws Exception{
        DynamicCircularQueue cq = new DynamicCircularQueue();
        cq.enqueue(5);
        cq.enqueue(4);
        cq.enqueue(3);
        cq.enqueue(2);
        cq.enqueue(1);
        cq.enqueue(0);
        cq.dequeue();
        cq.enqueue(-1);
        cq.display();
    }
}
