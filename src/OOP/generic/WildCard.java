package OOP.generic;
import java.util.Arrays;
import java.util.List;

public class WildCard<T extends Number> {

    private Object[] data;
    private static int DEFAULT_SIZE=10;
    private int size = 0;

    public WildCard(){
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    public Object get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void getList(List<? extends Number> list){

    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T remove(){
        return (T)data[--size];
    }

    private void resize(){
        Object[] temp = new Object[data.length * 2];

        //copy items in new array
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    private boolean isFull(){
        return size == data.length;
    }

    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        WildCard<Float> list = new WildCard<>();
        list.add(213.0f);
        list.add(34.3f);
        list.add(443f);
        System.out.println(list);

        WildCard<Integer> list2 = new WildCard<>();
        list2.add(43);
        list2.add(4543);
        System.out.println(list2);


    }
}
