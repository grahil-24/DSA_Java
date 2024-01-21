package ArraysAndHashing;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] nums3 = new int[length3];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < length1 && j < length2){
            if(nums1[i] < nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i <= length1-1){
            nums3[k] = nums1[i];
            k++;
            i++;
        }
        while(j <= length2-1){
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        int mid1 = length3 / 2;
        if(length3 % 2 == 0){
            int mid2 = mid1 - 1;
            res = (double) (nums3[mid1] + nums3[mid2]) /2;
        }else{
            res = nums3[mid1];
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }
}
