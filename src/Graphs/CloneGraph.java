package Graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {


    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node newRoot = new Node(1);
        map.put(1, newRoot);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            Node dupN = map.get(n.val);
            for(Node adj: n.neighbors){
                if(!map.containsKey(adj.val)){
                    queue.add(adj);
                    Node dupNode = new Node(adj.val);
                    map.put(adj.val,dupNode);
                    dupN.neighbors.add(dupNode);
                }else{
                    Node dupNode = map.get(adj.val);
                    dupN.neighbors.add(dupNode);
                }
            }
        }
        return newRoot;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(n1);
        System.out.println();
    }

}
