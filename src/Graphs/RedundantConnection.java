package Graphs;

import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] redundant = new int[2];
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        for(int i = 0; i<=edges.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(!union(edge[0], edge[1], parent, rank)){
                redundant[0] = edge[0];
                redundant[1] = edge[1];
            }
        }

        return redundant;
    }

    public int rank(int n, int[] parent){
        int par = parent[n];
        while(par != parent[par]){
            parent[par] = parent[parent[par]];
            par = parent[par];
        }
        return par;
    }

    public boolean union(int n1, int n2, int[] parent, int[] rank){
        int p1 = rank(n1, parent);
        int p2 = rank(n2, parent);
        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

}
