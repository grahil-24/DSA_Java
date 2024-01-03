package BinarySearch;

public class InfiniteSizeArray {

    public int binSearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid =  start + (end - start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int searchArray(int[] arr, int target){

        int count = 1;
        int start = 0;
        while(true){
            int end = (int)Math.pow(2, count) + start - 1;
            int res = binSearch(arr, target, start, end);
            if(res != -1){
                return res;
            }
            start = end + 1;
            count++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18};
        int target = 4;

        InfiniteSizeArray isa = new InfiniteSizeArray();
        int res = isa.searchArray(arr, target);
        System.out.println(res);

    }
}
