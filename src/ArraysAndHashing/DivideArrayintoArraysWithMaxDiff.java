package ArraysAndHashing;

import java.util.Arrays;

public class DivideArrayintoArraysWithMaxDiff {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int[][] res = new int[length/3][3];

        int i = 0;
        int row = 0;
        while(i < length){
            for(int j = i; j<=i+2; j++){
                if(nums[j] - nums[i] <= k){
                    res[row][j-i] = nums[j];
                }else{
                    res = new int[length/3][];
                    return res;
                }
            }
            i = i+3;
            row++;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
