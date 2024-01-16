package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {

    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] sortedNum = sort(nums);
        int length = nums.length;
        for(int i = 0; i < length-2; i++){
            if(i != 0 && (sortedNum[i] == sortedNum[i-1]) ){
                continue;
            }
            int ele = sortedNum[i];
            int l = i+1;
            int r = length-1;

            while(l < r){
                if(sortedNum[l] + ele + sortedNum[r] > 0){
                    r--;
                }else if(sortedNum[l] + ele + sortedNum[r] < 0){
                    l++;
                }else{
                    List<Integer> a = new ArrayList<>();
                    a.add(sortedNum[i]);
                    a.add(sortedNum[l]);
                    a.add(sortedNum[r]);
                    if(!res.contains(a)){
                        res.add(a);
                    }
                    l++;
                }
            }
        }

        return res;
    }

    public static int[] sort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] mergedArray = new int[left.length+right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int k=0;

        while(leftPointer < left.length && rightPointer < right.length ){
            if(left[leftPointer] < right[rightPointer]){
                mergedArray[k] = left[leftPointer];
                leftPointer++;
            }else{
                mergedArray[k] = right[rightPointer];
                rightPointer++;
            }
            k++;
        }

        while(leftPointer < left.length){
            mergedArray[k] = left[leftPointer];
            leftPointer++;
            k++;
        }
        while(rightPointer < right.length){
            mergedArray[k] = right[rightPointer];
            rightPointer++;
            k++;
        }
        return mergedArray;
    }


    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum(new int[]{0, 0, 0, 0}));
    }

}
