package AdvancedGraphs;

import java.util.*;

public class NetworkDelay_Dijkstra {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        int len = times.length;
        int res = 0;
        int vertices_count = 0;
        for(int i = 0; i < len; i++) {
            if(adjList.containsKey(times[i][0])) {
                adjList.get(times[i][0]).add(Arrays.asList(times[i][1], times[i][2]));
            }else{
                List<List<Integer>> list = new ArrayList<>();
                list.add(Arrays.asList(times[i][1], times[i][2]));
                adjList.put(times[i][0], list);
            }
        }

        if(!adjList.containsKey(k)){
            return -1;
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(list -> list.get(1)));
        HashSet<Integer> visited = new HashSet<>();
        pq.offer(Arrays.asList(k, 0));
        visited.add(k);
        while(!pq.isEmpty() && vertices_count < n){
            List<Integer> cur = pq.poll();
            int cur_node = cur.get(0);
            int cur_time = cur.get(1);
            visited.add(cur_node);
            res += cur_time;
            vertices_count++;
            List<List<Integer>> neighbors = adjList.get(cur_node);
            if(neighbors == null){
                continue;
            }
            for(List<Integer> neighbor : neighbors){
                if(visited.contains(neighbor.get(0))){
                    continue;
                }
                pq.offer(Arrays.asList(neighbor.get(0), neighbor.get(1) + cur_time));
            }
        }

        return vertices_count < n ? -1 : res;
    }

    public static void main(String[] args) {
        NetworkDelay_Dijkstra dijkstra = new NetworkDelay_Dijkstra();
        System.out.println(dijkstra.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4,2));
    }
}
