package BinarySearch;

public class TargetElementBS {
//

    public static int search(int[] arr, int element){
        int len = arr.length-1;
        int high=len;
        int low=0;
        int mid=0;
        boolean asc = arr[low] <= arr[high];

//        if(arr[high] < element && asc) {
//            return -1;
//        }else {
            while (low <= high) {
                mid = (high + low) / 2;
                if (arr[mid] > element) {
                    if(asc){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }

                } else if (arr[mid] < element) {
                    if(asc){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }

                } else {
                    return mid;
                }
            }
            if(asc){
                if(low > len){
                    return -1;
                }
                return low;
            }else{
                return high;
            }

        }
//    }

    public static int targetElement(int[] arr, int target){

        //[2,4, 5, 8, 13, 25] target = 7
        int targetElement = search(arr, target);

        return targetElement;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 8, 13, 24};
//        int[] arr = {24, 13, 8, 5, 4, 2};
        int targetElement = targetElement(arr, 23);
        System.out.println(targetElement);

    }
}
