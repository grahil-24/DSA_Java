package Heap.Leetcode;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;
    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>((a, b)->Integer.compare(b, a));
    }

    public void addNum(int num) {
        if(min_heap.isEmpty() || num < min_heap.peek() || max_heap.isEmpty()){
            max_heap.add(num);
        }else{
            min_heap.add(num);
        }
        if(max_heap.size() - min_heap.size() > 1){
            min_heap.add(max_heap.remove());
        }
        if(min_heap.size() - max_heap.size() > 1){
            max_heap.add(min_heap.remove());
        }
    }

    public double findMedian() {
        double median =0;
        if(min_heap.size() > max_heap.size()){
            median = min_heap.peek();
        }else if(max_heap.size() > min_heap.size()){
            median  = max_heap.peek();
        }else{
            median = (double) (min_heap.peek() + max_heap.peek()) /2;
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
