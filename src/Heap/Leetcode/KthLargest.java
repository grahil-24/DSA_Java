package Heap.Leetcode;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> queue;
    int k_index;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(10);
        for(int num: nums){
            queue.offer(num);
        }
        k_index = k;
    }

    public int add(int val) {
        queue.offer(val);
        while(queue.size() > k_index){
            queue.remove();
        }
        return queue.peek();
    }
}

