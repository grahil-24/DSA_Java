package Stack;

public class DynamicStack extends MyStack{

    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int num){
        if(this.isFull()){
            //double the array size
            int[] newArr = new int[data.length * 2];

            for(int i = 0; i<data.length; i++){
                newArr[i] = data[i];
            }
            data = newArr;
        }
        ptr++;
        data[ptr] = num;
    }
}
