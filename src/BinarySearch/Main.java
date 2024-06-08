package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[4];

        Scanner in = new Scanner(System.in);

        for(int i =0; i<str.length; i++){
            str[i] = in.next();
        }
        System.out.println(Arrays.toString(str));
        str[1] = "w";
        System.out.println(Arrays.toString(str));

        ArrayList<Integer> list = new ArrayList<>(10);

        list.add(67);
        list.add(57);
        list.add(37);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.add(27);
        list.set(0, 44);
        list.remove(2);
        System.out.println(list);

    }
}