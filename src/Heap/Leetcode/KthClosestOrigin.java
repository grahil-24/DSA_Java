package Heap.Leetcode;

import java.util.*;

public class KthClosestOrigin {



    public int[][] kClosest(int[][] points, int k) {
            Map<Integer, List<int[]>> map= new HashMap<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int[] coords: points){
                int dist = (int)(Math.pow(coords[0], 2) + Math.pow(coords[1], 2));
                queue.offer(dist);
                if(map.containsKey(dist)){
                    List<int[]> res = map.get(dist);
                    res.add(coords);
                    map.put(dist, res);
                }else{
                    map.put(dist, new ArrayList<>(Collections.singleton(coords)));
                }
            }

            int[][] res = new int[k][];
            int count = 0;
            while(count < k){
                double dist = queue.remove();
                List<int[]> coords = map.get(dist);
                for(int i = 0; i<coords.size() && count < k; i++){
                    res[count] = coords.get(i);
                    count++;
                }
            }

            return res;
    }

    public static void main(String[] args) {
        KthClosestOrigin kco = new KthClosestOrigin();
        int[][] arr = {{1, 3}, {-2 ,2}};
        System.out.println(Arrays.toString(kco.kClosest(arr, 1)));

    }

}
