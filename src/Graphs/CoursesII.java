package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoursesII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i< prerequisites.length; i++){
            int parent = prerequisites[i][0];
            List<Integer> child = adj.get(parent);
            child.add(prerequisites[i][1]);
        }

        int[] order = new int[numCourses];
        int index = 0;
        for(int i = 0; i < numCourses; i++){
            if(visited[i] != 1){
                if(isCyclic(visited, adj, i, order, index)){
                    return new int[]{};
                }else{
                    order[i] = i;
                    index++;
                }
            }
        }
        return order;
    }

    public boolean isCyclic(int[] visited, List<List<Integer>> adj, int current, int[] order, int index){
        if(visited[current] == 2){
            return true;
        }

        visited[current] =2;
        List<Integer> child = adj.get(current);
        for(int i = 0; i<child.size(); i++){
            if(visited[child.get(i)] != 1){
                if(isCyclic(visited, adj, child.get(i), order, index)){
                    return true;
                }
            }
        }
        visited[current] = 1;
        index++;
        order[index] = current;
        return false;
    }

    public static void main(String[] args) {
        CoursesII c = new CoursesII();
        int[] order = c.findOrder(2, new int[][]{{1,0}});
        for(int i = 0; i < order.length; i++){
            System.out.print(STR."\{order[i]} ");
        }
        System.out.println();
    }
}
