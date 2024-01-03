package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dupnum_CS {

    public int findDuplicate(int[] nums) {

        int length = nums.length;
        boolean atCorrectPos = false;

        for(int i =0; i< length; i++){
            if(nums[i] > length){
                continue;
            }
            while(!atCorrectPos){
                if(nums[i] > length){
                    break;
                }
                if(nums[i] == i+1){
                    atCorrectPos = true;
                }else{
                    if(nums[i] == nums[nums[i]-1]){
                        return nums[i];
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                }
            }
            atCorrectPos = false;
        }

        return -1;
    }

    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        boolean atCorrectPos = false;
        List<Integer> dups = new ArrayList<>();

        for(int i =0; i< length; i++){
            int num = nums[i];
            if(num > length){
                continue;
            }
            while(!atCorrectPos){

                if(num == i+1){
                    atCorrectPos = true;
                }else{
                    if(nums[i] == nums[nums[i]-1]){
                        if(!dups.contains(nums[i])){
                            dups.add(nums[i]);
                        }

                        break;
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                }
            }
            atCorrectPos = false;
        }

        return dups;

    }

    public int[] dupDelete(int[] nums){
        int length = nums.length;
        boolean atCorrectPos = false;
        int[] dups = new int[2];
        int dupIndex = 0;
        for(int i =0; i< length; i++){
            int num = nums[i];
            if(num > length){
                continue;
            }
            while(!atCorrectPos){
                num = nums[i];
                if(num == i+1){
                    atCorrectPos = true;
                }else{
                    if(num == nums[num-1]){
                        dups[0] = num;
                        dups[1] = i+ 1;
                        break;
                    }
//                    int temp = nums[i];
                    nums[i] = nums[num-1];
                    nums[num-1]= num;
                }
            }
            atCorrectPos = false;
        }

        return dups;
    }




    public static void main(String[] args) {
        Dupnum_CS dc = new Dupnum_CS();
        int[] arr = {3, 2,2};
        System.out.println(Arrays.toString(dc.dupDelete(arr)));
    }
}
