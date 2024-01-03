package misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergedArrayMedian {


    public void addNum(List<Integer> list, int num, int start){

        int end = list.size();
        int mid = 0;
        while(start<=end){
            mid = start + (end - start) /2;
            if(list.get(mid) > num){
                end = mid - 1;
            }else if(list.get(mid) < num){
                start = mid + 1;
            }else{
                list.add(mid+1, num);
            }
        }
        if(list.get(mid) < num){
            list.add(mid+1, num);
        }else{
            list.add(end, num);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        double median = 0.0;

        List<Integer> mergedList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        for(int i: nums2){
            this.addNum(mergedList, i, 0);
        }

        System.out.println(mergedList);
        return median;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4};

        MergedArrayMedian mam = new MergedArrayMedian();
        mam.findMedianSortedArrays(nums1, nums2);
    }
}
