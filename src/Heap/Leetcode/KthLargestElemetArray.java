package Heap.Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElemetArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        int count =0;
        while(queue.size() != k){
            queue.offer(nums[count]);
            count++;
        }
        while(count <= nums.length - 1){
            if(queue.peek() < nums[count]){
                queue.remove();
                queue.offer(nums[count]);
            }
            count++;
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        KthLargestElemetArray kla = new KthLargestElemetArray();
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(kla.findKthLargest(arr, 4));

    }

}
