package Trees;

import java.nio.file.Path;
import java.util.*;

public class WaterJugGraph{

    int capacity_1;
    int capacity_2;

    Map<List<Integer>, List<List<Integer>>> adjacencyMap;
    Set<List<Integer>>  adjacencySet;
    public WaterJugGraph(int capacity_1, int capacity_2){
        this.capacity_1 = capacity_1;
        this.capacity_2 = capacity_2;
        adjacencyMap = new HashMap<>();
        adjacencySet = new HashSet<>();
    }

    public void dfs(){
        Stack<List<Integer>> path = new Stack<>();
        boolean res = dfs(0, this.capacity_1, 0, this.capacity_2, path);
        if(res){
            System.out.println(path);
        }else{
            System.out.println("Capacity cant be measured!");
        }
    }

    private boolean dfs(int filled_1, int capacity_1, int filled_2, int capacity_2, Stack<List<Integer>> path){
        List<Integer> node = Arrays.asList(filled_1, filled_2);
        path.push(node);
        if((filled_1 == 2 && filled_2 == 0) || (filled_1 == 0 && filled_2 == 2)){
            return true;
        }
        if (!adjacencySet.contains(node)) {
            adjacencySet.add(node);
            // fill jug_1
            if (filled_1 < capacity_1) {
                if (dfs(capacity_1, capacity_1, filled_2, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
            // fill jug_2
            if (filled_2 < capacity_2) {
                if (dfs(filled_1, capacity_1, capacity_2, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
            // transfer from jug1 to jug2
            if (filled_1 != 0 && (filled_2 < capacity_2)) {
                int rem_amt = Math.min(capacity_2 - filled_2, filled_1);
                if (dfs(filled_1 - rem_amt, capacity_1, filled_2 + rem_amt, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
            // transfer from jug2 to jug1
            if (filled_2 != 0 && (filled_1 < capacity_1)) {
                int rem_amt = Math.min(capacity_1 - filled_1, filled_2);
                if (dfs(filled_1 + rem_amt, capacity_1, filled_2 - rem_amt, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
            // empty jug1
            if (filled_1 != 0) {
                if (dfs(0, capacity_1, filled_2, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
            // empty jug2
            if (filled_2 != 0) {
                if (dfs(filled_1, capacity_1, 0, capacity_2, path)) {
                    return true;
                }
                path.pop();
            }
        }
        return false;
    }

    public void bfs(int filled_1, int filled_2, int target){
        List<List<Integer>> path = new ArrayList<>();
        if(bfs(filled_1, capacity_1, filled_2, capacity_2, target, path)){
            System.out.println("Volume can be measured!");

        }else{
            System.out.println("Volume cannot be measured!");
        }
        System.out.println("Path traversed: ");
        System.out.println(path);
    }

    private boolean bfs(int filled_1, int capacity_1, int filled_2, int capacity_2, int target, List<List<Integer>> path){
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> root = Arrays.asList(filled_1, filled_2);
        boolean qtmeasured = false;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> node = queue.poll();
            filled_1 = node.get(0);
            filled_2 = node.get(1);
            path.add(node);
            if(filled_1 == target || filled_2 == target){
                qtmeasured = true;
                break;
            }
            if(adjacencySet.contains(node)){
                continue;
            }
            adjacencySet.add(node);
            if (filled_1 < capacity_1) {
                queue.offer(Arrays.asList(capacity_1, filled_2));
            }
            // fill jug_2
            if (filled_2 < capacity_2) {
                queue.offer(Arrays.asList(filled_1, capacity_2));
            }
            // transfer from jug1 to jug2
            if (filled_1 != 0 && (filled_2 < capacity_2)) {
                int rem_amt = Math.min(capacity_2 - filled_2, filled_1);
                queue.offer(Arrays.asList(filled_1 - rem_amt, filled_2 + rem_amt));
            }
            // transfer from jug2 to jug1
            if (filled_2 != 0 && (filled_1 < capacity_1)) {
                int rem_amt = Math.min(capacity_1 - filled_1, filled_2);
                queue.offer(Arrays.asList(filled_1 + rem_amt, filled_2 - rem_amt));
            }
            // empty jug1
            if (filled_1 != 0) {
                queue.offer(Arrays.asList(0, filled_2));
            }
            // empty jug2
            if (filled_2 != 0) {
                queue.offer(Arrays.asList(filled_1, 0));
            }
        }
        return qtmeasured;
    }


    public void printTree(){
//        for(List<Integer> list: adjacencyMap.keySet()){
//            for(List<Integer> list1: adjacencyMap.get(list)){
//                System.out.println("child of"+list+": "+list1);
//            }
//        }
        System.out.println(adjacencySet);
    }

    public static void main(String[] args) {
       WaterJugGraph wjg = new WaterJugGraph(3, 2);
       wjg.bfs(0, 0, 1);
    }
}