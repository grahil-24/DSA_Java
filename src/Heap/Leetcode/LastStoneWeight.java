package Heap.Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {


    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int wt: stones){
            queue.offer(wt);
        }

        while(queue.size() > 1){
            int w1 = queue.remove();
            int w2 = queue.remove();
            int res_wt = Math.abs(w1 - w2);
            if(res_wt == 0){
                continue;
            }else{
                queue.offer(res_wt);
            }
        }
        if(queue.isEmpty()){
            return 0;
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        LastStoneWeight lsw = new LastStoneWeight();
        int[] stones = {1};
        System.out.println(lsw.lastStoneWeight(stones));
    }

}
