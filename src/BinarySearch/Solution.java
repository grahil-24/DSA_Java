package BinarySearch;

class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int high=letters.length-1;
        int low=0;
        int mid=0;
//  
        while (low <= high) {
            mid = (high + low) / 2;
            if (letters[mid] > target) {
                high = mid - 1;
            } else if (letters[mid] < target) {
                low = mid + 1;
            } else {
                return letters[mid+1];
            }
        }
        if(low > high){
            return letters[0];
        }
        return letters[low];

    }

    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'g'};
        char ele = nextGreatestLetter(arr, 'd');
        System.out.println(ele);
    }
}
