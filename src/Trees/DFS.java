package Trees;

public class DFS {

    Node root;
    int size;
    public DFS(Node node){
        this.root = node;
    }

    public boolean search(Node node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            System.out.println("Element found: " + val);
            return true;
        }

        boolean foundLeft = search(node.leftNode, val);
        boolean foundRight = search(node.rightNode, val);

        return foundLeft || foundRight;
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(6);
        root.leftNode = n1;
        Node n2 = new Node(7);
        root.rightNode = n2;
        Node n3 = new Node(8);
        n1.leftNode = n3;
        DFS dfs = new DFS(root);
        dfs.search(root, 8);
    }

}

class Node{

    int val;
    Node leftNode;
    Node rightNode;

    public Node(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public void setVal(){
        this.val = val;
    }

    public void insertLeft(Node node){
        this.leftNode = node;
    }

    public void insertRight(Node node){
        this.rightNode = node;
    }
}


