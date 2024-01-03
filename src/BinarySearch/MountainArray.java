package BinarySearch;

public class MountainArray {

    public int findPeak(int[] arr){
        int start = 0;

        int length = arr.length - 1;
        int end = length;

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        MountainArray ma = new MountainArray();
        int[] arr = {1,2,3,5,3};
        int res = ma.findPeak(arr);
        System.out.println(res);
    }
}
