package Graphs;

import java.util.*;

public class Graph {

    private final ArrayList<ArrayList<Integer>> adjacencyList;
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
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
        if(dfs(source, goal,visited, path)){
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num+"->");
            }
            printFinalPath(path);
        }else{
            System.out.println("Goal node not found in tree");
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num+"->");
            }
        }
    }

    public boolean dfs(int source, int goal, ArrayList<Integer> visited, ArrayList<Integer> path){
        visited.set(source, 1);
        path.add(source);
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

    public void dls(int source, int goal, int depth){
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
        if(dls(source, goal,visited, path, 0, depth)){
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num+"->");
            }
            printFinalPath(path);
        }else{
            System.out.println("Goal node not found in tree");
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num+"->");
            }
        }
    }

    public boolean dls(int source, int goal, ArrayList<Integer> visited, ArrayList<Integer> path, int depth, int limit){
        visited.set(source, 1);
        path.add(source);
        if(source == goal){
            return true;
        }
        ArrayList<Integer> neighbours = adjacencyList.get(source);
        for(int num: neighbours){
            if(visited.get(num)!= 1 && depth < limit){
                if (dls(num, goal, visited, path, depth+1, limit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void iterativeDeepeningSearch(int source, int goal, int maxDepth){
        boolean goalReached = false;
        int depth = 0;
        ArrayList<Integer> visited;
        ArrayList<Integer> path = null;
        while(!goalReached && depth < maxDepth){
            visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
            path = new ArrayList<>();
            goalReached = dls(source, goal, visited, path, 0, depth);
            depth++;
        }
        if(goalReached){
            System.out.println("Goal reached at depth " + (depth-1) + " Path: "+path);
        }else{
            System.out.println("Goal not found!");
        }
    }

    public void bfs(int source, int goal){
        ArrayList<Integer> path = new ArrayList<>();
        if(bfs(source ,goal, path)){
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num + "->");
            }
            printFinalPath(path);
        }else{
            System.out.println("Goal node not found in tree");
            System.out.println("Traversing order: ");
            for(int num: path){
                System.out.print(num+"->");
            }
        }
    }

    public boolean bfs(int source, int goal, ArrayList<Integer> path){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(numOfVertices+1, 0));
        queue.add(source);
        int currentNode;
        visited.set(source, 1);
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            path.add(currentNode);
            if(currentNode == goal){
                return true;
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
        return false;
    }

    public void printFinalPath(ArrayList<Integer> path){
        System.out.println("\nFinal Path: ");
        int i = path.size()-1;
        while(i-1 >=0){
            if(!adjacencyList.get(path.get(i-1)).contains(path.get(i))){
                path.remove(i-1);
            }
            i--;
        }
        for(int num: path){
            System.out.print(num+"->");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);
        graph.addEdge(4, 9);
        graph.addEdge(6, 10);

        graph.dfs(1, 7);
    }
}
