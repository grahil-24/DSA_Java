package BinarySearch;

public class SearchInMountain {

    //Eg: [1, 2, 3, 4, 5, 3, 1]. Find for 3
    // Find the peak element

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

    public int search(int[] arr, int target){
        int end = arr.length-1;
        int peak = findPeak(arr);
        int index1 = binarySearch(arr, target, 0, peak);
        if(index1 != -1) {
            return index1;
        }
        int index2 = binarySearch(arr, target, peak+1, end);
        if(index2 != -1){
            return index2;
        }else{
            return -1;
        }

    }

    public int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;

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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target= 7;

        SearchInMountain sim = new SearchInMountain();
        int res = sim.search(arr, target);
        System.out.println(res);
    }
}
