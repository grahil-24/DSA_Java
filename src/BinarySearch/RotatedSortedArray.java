package BinarySearch;

public class RotatedSortedArray {


    public int binarySearch(int[] arr, int target,int start, int end){

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

    public int findPivot(int[] arr){

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(start <= end){

            mid = start + (end - start)/2;
            if(arr[mid] >= arr[start] && arr[mid] < arr[end]){
                start = mid + 1;
            }else if(arr[mid] > arr[start] && arr[mid] > arr[end]){
                start = mid;
            }else if(arr[mid] < arr[start] && arr[mid] < arr[end]){
                end = mid;
            }else{
                return mid;
            }
        }

        return mid;
    }

    public int findPivotWithDup(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid -1]){
                return mid -1;
            }
            // if element at middle, start and end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates.
                //NOTE: what happens if the elements at start or end are the pivot?
                //check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                //check whether end is pivot
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    public int search(int[] arr, int target){

        int peak = this.findPivot(arr);
        int start;
        int end;
        int res;
        if(target <= arr[peak] && target >= arr[0]){
            start = 0;
            end = peak;
            res = this.binarySearch(arr, target, start, end);
        }else{
            start= peak + 1;
            end = arr.length - 1;
            res = this.binarySearch(arr, target, start, end);
        }

        return res;
    }

    public static void main(String[] args) {

        RotatedSortedArray rsa = new RotatedSortedArray();
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int ele = rsa.findPivotWithDup(arr);
        System.out.println(ele);

    }
}
