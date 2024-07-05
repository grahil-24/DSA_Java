package AdvancedGraphs;

import java.util.*;

public class MinCost_ConnectAllPoints_Prim {

    public int minCostConnectPoints(int[][] points) {

        int res = 0;
        int edges_required = points.length - 1;
        int edges_included = 0;
        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int src = i;
            List<List<Integer>> edges = new ArrayList<>();
            for (int j = 0; j < points.length; j++) {
                if(i != j){
                    int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(Arrays.asList(j, cost));
                }
            }
            adjList.put(src, edges);
        }

        HashSet<Integer> visited =new HashSet<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge.get(1)));
        pq.offer(Arrays.asList(0, 0));
        while (!pq.isEmpty() && edges_included <= edges_required) {
            List<Integer> curr = pq.poll();
            System.out.println(curr);
            if(visited.contains(curr.get(0))){
                continue;
            }
            visited.add(curr.get(0));
            edges_included++;
            res += curr.get(1);
            List<List<Integer>> neighbors = adjList.get(curr.get(0));
            for (List<Integer> neighbor : neighbors) {
                if (!visited.contains(neighbor.get(0))) {
                    pq.offer(neighbor);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinCost_ConnectAllPoints_Prim minCost = new MinCost_ConnectAllPoints_Prim();
        System.out.println(minCost.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
    }
}
