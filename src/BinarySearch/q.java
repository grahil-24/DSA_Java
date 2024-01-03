package BinarySearch;

public class q {


    public static int getStart(int[] arr, int target, int start, int end){
        int startIndex = end + 1;
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
                startIndex = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return startIndex;
    }

    public static int getEnd(int[] arr, int target, int start, int end){
        int endIndex = start - 1;
        while(start <=end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                endIndex = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return endIndex;
    }
    public static int[] searchRange(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int[] range = {-1, -1};
        int length = arr.length;
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                range[0] = getStart(arr, target, 0, mid-1);
                range[1] = getEnd(arr, target ,mid+1, length-1);
                break;
            }
        }
        return range;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] range = searchRange(arr, 5);
        System.out.println(range[0] + " " + range[1]);
    }

}
