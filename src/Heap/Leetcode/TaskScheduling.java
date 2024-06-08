package Heap.Leetcode;

import java.util.*;

class TaskScheduling {

    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] freq = new int[26];
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(freq[b - 'A'], freq[a - 'A']));
        //making a frequency map of characters in tasks array
        for(char ch: tasks){
            freq[ch - 'A']++;
            if(!maxHeap.contains(ch)){
                maxHeap.add(ch);
            }
        }

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                char ch = maxHeap.poll();
                System.out.print(STR."\{ch}->");
                freq[ch - 'A']-=1;
                if (freq[ch - 'A'] > 0) {
                    queue.offer(new int[]{ch - 'A', time + n});
                }
            }
            if(!queue.isEmpty()){
                int nextTime = queue.peek()[1];
                if(time == nextTime){
                    char ch = (char)('A' + queue.poll()[0]);
                    maxHeap.add(ch);
                }
            }

        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduling ts = new TaskScheduling();
        char[] tasks = {'A', 'B', 'C', 'D', 'E'};
        int n = 1;
        System.out.println(ts.leastInterval(tasks, n));
    }
}