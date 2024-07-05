package Greedy;

import java.util.*;

public class StraightHands {


    public boolean isNStraightHand(int[] hand, int groupSize) {

        int size = hand.length;
        if(size % groupSize != 0) return false;

        Set<Integer> visited = new HashSet<>();

        Arrays.sort(hand);
        for(int i = 0; i < size; i++) {
            if(visited.contains(i)){
                continue;
            }
            visited.add(i);
            int val = hand[i];
            int count = 1;
            int counter = i+1;
            while(counter < size && count < groupSize){
                if(visited.contains(counter)){
                    counter++;
                    continue;
                }
                if(hand[counter] > val + 1){
                    return false;
                }else if(hand[counter] == val + 1){
                    val = hand[counter];
                    visited.add(counter);
                    count++;
                    counter++;
                }else{
                    counter++;
                }
            }
            if(count < groupSize){
                return false;
            }
        }
        System.out.println();
        return true;
    }

    public boolean isStraightHand(int[] hand, int groupSize) {
        int size = hand.length;
        if(size % groupSize != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            int val = hand[i];
            if(map.containsKey(val)){
                int count = map.get(val);
                map.put(val, count + 1);
            }else{
                map.put(val, 1);
                pq.offer(val);
            }
        }
        while(!pq.isEmpty()){
            int least = pq.peek();
            int count = map.get(least);
            if(map.get(least) == 1){
                pq.poll();
            }else if(map.get(least) == 0){
                pq.poll();
                continue;
            }
            map.put(least, count -1);
            for(int i = 1; i< groupSize; i++){
                int next_val = least + i;
                if(!map.containsKey(next_val)){
                    return false;
                }else{
                    int next_val_count = map.get(next_val);
                    if(next_val_count == 0){
                        return false;
                    }else{
                        map.put(next_val, next_val_count - 1);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StraightHands sh = new StraightHands();
        System.out.println(sh.isStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
