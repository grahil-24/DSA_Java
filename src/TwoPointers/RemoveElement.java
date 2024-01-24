package TwoPointers;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int t_count = 0;
        int i = 0;
        int length = nums.length;
        while(i < length) {
            if(nums[i] == val) {
                int j = i;
                int count = -1;
                while(j < length && nums[j] == val ) {
                    count++;
                    j++;

                }
                t_count+=count;
                if(j < length){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;

        }
        return t_count+1;
    }


    public static void main(String[] args) {
        System.out.println(RemoveElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}

