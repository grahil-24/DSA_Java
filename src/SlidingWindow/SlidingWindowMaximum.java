package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        int maxAt = 0;
        while(i<=(length - k)){
            for(int j = maxAt; j<i+k; j++){
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[j]){
                    deque.removeLast();
                }
                deque.addLast(j);
            }
            res[i] = nums[deque.peekFirst()];
            maxAt = deque.peekLast();
            if(maxAt < i+1){
                deque.removeFirst();
            }

            i++;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(SlidingWindowMaximum.maxSlidingWindow(new int[]{1,3,
        1, 2, 0, 5}, 3)));
    }
}
