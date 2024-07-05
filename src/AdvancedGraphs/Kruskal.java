package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        int edges_required = points.length - 1;
        int edges_included = 0;
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new ArrayList<>(Arrays.asList(i, j, cost)));
            }
        }

        if (edges.size() > 1) {
            edges.sort(Comparator.comparing(edge -> edge.get(2)));
        }

        int[] parents = new int[points.length];
        int[] ranks = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (List<Integer> edge : edges) {
            if (edges_included == edges_required) {
                return res;
            }
            if (!union(edge.get(0), edge.get(1), parents, ranks)) {
                continue;
            }
            res += edge.get(2);
            edges_included++;
        }

        return res;
    }

    public int find(int n, int[] parent) {
        if (parent[n] != n) {
            parent[n] = find(parent[n], parent);  // Path compression
        }
        return parent[n];
    }

    public boolean union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if (p1 == p2) return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
        return true;
    }

    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        System.out.println(k.minCostConnectPoints(new int[][]{{-2,-2}, {2, 2}}));
    }
}
