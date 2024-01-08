package ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i)){
                return false;
            }
            set.add(i);
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
