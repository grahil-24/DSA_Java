package Sorting;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNum_CyclicSort {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> dis = new ArrayList<>();
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
                        break;
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                }
            }
            atCorrectPos = false;
        }

        for(int i = 0; i< length; i++){
            if(nums[i] != i+1){
                dis.add(i+1);
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        DisappearedNum_CyclicSort dn = new DisappearedNum_CyclicSort();
        int[] arr = {1, 1};
        System.out.println(dn.findDisappearedNumbers(arr));
    }
}
