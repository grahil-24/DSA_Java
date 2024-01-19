package Graphs;

import java.util.*;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    int numOfVertices;

    public Graph(int numOfVertices){
        adjacencyList = new ArrayList<>();
        this.numOfVertices = numOfVertices;
        for(int i =0; i<= numOfVertices; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2){
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void printAdjacencyList() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");
            System.out.println(adjacencyList.get(i));
        }
    }

    public void dfs(int source, int goal){
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
        Stack<Integer> path = new Stack<>();
        boolean ans = dfs(source, goal, visited, path);
        if(ans){
            System.out.println(path.toString());
        }else{
            System.out.println("Goal node not found!");
        }
    }

    public boolean dfs(int source, int goal, ArrayList<Integer> visited, Stack<Integer> path){
        visited.set(source, 1);
        System.out.print(source+"->");
        if(source == goal){
            return true;
        }
        ArrayList<Integer> neighbours = adjacencyList.get(source);
        for(int num: neighbours){
            if(visited.get(num)!= 1){
                if (dfs(num, goal, visited, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void bfs(int source, int goal){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
        queue.add(source);
        int currentNode = source;
        visited.set(source, 1);
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            System.out.print(currentNode+"->");
            if(currentNode == goal){
                return;
            }
            ArrayList<Integer> neighbours = adjacencyList.get(currentNode);
            for(int num: neighbours){
                if(visited.get(num) == 1){
                    continue;
                }else{
                    visited.set(num , 1);
                    queue.add(num);
                }
            }

        }
        System.out.println();
        System.out.println("Goal node was not found in the tree!");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        // Add edges
        graph.addEdge(1, 8);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 9);
        graph.addEdge(8, 4);
        graph.addEdge(8, 6);
        graph.addEdge(8, 3);
        graph.addEdge(6, 10);
        graph.addEdge(6, 7);

        // Print the adjacency list
        graph.dfs(1, 3);
    }
}
