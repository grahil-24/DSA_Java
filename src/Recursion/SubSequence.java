package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubSequence {

    static ArrayList<String> subseq(String p, String up){
        ArrayList<String> res = new ArrayList<>();
        if(up.isEmpty()){
            res.add(p);
            System.out.println(p);
            return res;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subseq(p + ch, up.substring(1));
        ArrayList<String> right = subseq(p, up.substring(1));
        left.addAll(right);
        res.addAll(left);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subseq("", "abc"));
    }
}
