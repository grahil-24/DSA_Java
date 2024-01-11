package ArraysAndHashing;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int count = 0;
        for(int num: nums){
            if(num == 0){
                count++;
            }else{
                prod = prod * num;
            }

        }
        int length = nums.length;
        if(count > 1){
            for(int i = 0; i< length; i++){
                nums[i] = 0;
            }
            return nums;
        }

        for(int i = 0; i < length; i++){
            if(count == 1){
                if(nums[i] == 0){
                    nums[i] = prod;
                }else{
                    nums[i] = 0;
                }
            }else{
                nums[i] = prod / nums[i];
            }

        }
        return nums;
    }

    public static void main(String[] args) {

    }

}
