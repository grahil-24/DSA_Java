package OOP.Cloning;

import java.util.Arrays;

public class Human implements Cloneable{

    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3, 4, 5, 6, 9, 1};
    }

    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Human twin = (Human) super.clone();     //shallow copy

        twin.arr = new int[twin.arr.length];
        for(int i=0; i<twin.arr.length; i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }




    public static void main(String[] args) throws CloneNotSupportedException{
        Human human = new Human(17, "rahil");
        Human twin = (Human) human.clone();
        System.out.println(twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[3] = 7;
        System.out.println(Arrays.toString(human.arr));
        System.out.println(Arrays.toString(twin.arr));
        twin.name="kunal";
        System.out.println(human.name);
        System.out.println(twin.name);
    }


}
