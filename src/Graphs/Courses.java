package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Courses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i< numCourses; i++){
            if(visited[i] == 0){
                if(isCyclic(adj, visited, i)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isCyclic(List<List<Integer>> adj, int[] visited, int index){
        if(visited[index] == 2){
            return true;
        }

        visited[index] = 2;
        for(int i = 0; i<adj.get(index).size(); i++){
            if(visited[adj.get(index).get(i)]!= 1){
                if(isCyclic(adj, visited, adj.get(index).get(i))){
                    return true;
                }
            }
        }
        visited[index]= 1;
        return false;
    }
}

