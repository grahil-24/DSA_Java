package misc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    public int factorial(int length){
        int fact = 1;

        for(int i=length ; i>= 1; i-- ){
            fact = fact * i;
        }

        return fact;
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> permutations = new ArrayList<>();
        int length = nums.length;
        int factorial = this.factorial(length);



        return permutations;
    }

    public static void main(String[] args) {

    }
}
