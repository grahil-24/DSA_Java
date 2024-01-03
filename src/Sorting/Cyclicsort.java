package Sorting;

import java.util.Arrays;

public class Cyclicsort {


    //whenever the question is of type like range of number from 1 to n. we perform cyclic sort
    public int[] sort(int[] arr){

        int length = arr.length;
        boolean atCorrectPos = false;

        for(int i =0; i< length-1; i++){
            while(!atCorrectPos){
                if(arr[i] == i+1){
                    atCorrectPos = true;
                }else{
                    int temp = arr[i];
                    arr[i] = arr[temp-1];
                    arr[temp-1]= temp;
                }
            }
            atCorrectPos = false;
        }

        return arr;
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        boolean atCorrectPos = false;

        for(int i =0; i< length; i++){
            if(nums[i] >= length){
                continue;
            }
            while(!atCorrectPos){
                if(nums[i] >= length){
                    break;
                }
                if(nums[i] == i){
                    atCorrectPos = true;
                }else{
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp]= temp;
                }
            }
            atCorrectPos = false;
        }

        for(int i = 0; i< length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return -1;
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean atCorrectPos = false;

        for(int i =0; i< length-1; i++){
            if(nums[i] > length || nums[i] <=0){
                continue;
            }
            while(!atCorrectPos){
                if(nums[i] > length || nums[i] <= 0 || (nums[i] == nums[nums[i]-1])){
                    break;
                }
                if(nums[i] == i+1){
                    atCorrectPos = true;
                }else{
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                }
            }
            atCorrectPos = false;
        }

        for(int i = 0;i<length; i++){
            if(nums[i]!= i+1){
                return i+1;
            }
        }
        return length+1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2} ;

        Cyclicsort cs = new Cyclicsort();
        System.out.println(cs.firstMissingPositive(arr));
    }
}
