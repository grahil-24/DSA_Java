package TwoPointers;

import java.util.Arrays;

public class TwoSum_2 {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int length = numbers.length;
        int j = length -1;
        int i = 0;
        while(true){
            if((numbers[i] + numbers[j] > target)){
                j--;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum_2.twoSum(new int[]{-1, 0}, -1)));
    }
}
