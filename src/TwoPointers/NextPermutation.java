package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair{
    int value;
    int index;

    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int length = nums.length;

        int i = length;
        int j_min = -1;
        int min_ele = 101;
        int i_min = 0;
        while(i > 0 && i !=  j_min-1){
            i--;
            int j = i-1;
            if(nums[i] == 0){
                continue;
            }
            while(j>=0){
                if(nums[i] > nums[j]){
                    if(j > j_min){
                        j_min = j;
                        min_ele = nums[i];
                        i_min = i;
                        break;
                    }else if(j == j_min){
                        if(nums[i] < min_ele){
                            min_ele = nums[i];
                            i_min = i;
                        }
                        break;
                    }else{
                        j--;
                    }
                }else{
                    j--;
                }
            }
        }

        if(j_min == -1){
            Arrays.sort(nums);
        }else{
            int temp = nums[i_min];
            nums[i_min] = nums[j_min];
            nums[j_min] = temp;
            Arrays.sort(nums, j_min+1, length);
        }

    }

    public static void main(String[] args) {
        NextPermutation.nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
    }
}
