package OOP.generic;
import java.util.Arrays;

public class CustomArrayList<T> {

    private Object[] data;
    private static int DEFAULT_SIZE=10;
    private int size = 0;

    public CustomArrayList(){
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
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Sddknfdk");
        list.add("kandkad");
        System.out.println(list);

        CustomArrayList<Integer> list2 = new CustomArrayList<>();
        list2.add(43);
        list2.add(4543);
        System.out.println(list2);




    }
}
