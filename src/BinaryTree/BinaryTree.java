package BinaryTree;

import java.util.*;

public class BinaryTree {

    static int index = 0;

    private Node root;
    public BinaryTree(){

    }
    public void populate(Scanner scanner){
        System.out.println("Enter value for root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    public void preorderTraversal(){
        preorderTraversal(root);
    }

    public void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void postorderTraversal(){
        postorderTraversal(root);
    }

    public void postorderTraversal(Node node){
        if(node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.value);
    }

    public void inorderTraversal(){
        inorderTraversal(root);
    }

    public void inorderTraversal(Node node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.value);
        inorderTraversal(node.right);
    }



    public void populate(Scanner scanner, Node root){
        System.out.println("Do you want to create a left child for: "+root.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println(STR."Enter the value for the left child of \{root.value}");
            int value = scanner.nextInt();
            Node leftChild = new Node(value);
            root.left = leftChild;
            populate(scanner, root.left);
        }
        System.out.println("Do you want to create a right child for: "+root.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value for the right child of "+root.value);
            int value = scanner.nextInt();
            Node rightChild = new Node(value);
            root.right = rightChild;
            populate(scanner, root.right);
        }

    }

    public void bfs(){
        Node tmp_root = root;
        Queue<Node> queue = new LinkedList<>();
        if(tmp_root == null){
            System.out.println("Empty tree!");
            return;
        }
        queue.add(tmp_root);
        System.out.println(tmp_root.value);
        while(!queue.isEmpty()){
            Node node = queue.remove();

            if(node.left != null){
                queue.add(node.left);
                System.out.println(node.left.value);
            }
            if(node.right != null){
                queue.add(node.right);
                System.out.println(node.right.value);
            }
        }
    }

    public void bfsTarget(int target){
        Node tmp_root = root;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean rootFound = false;
        if(tmp_root == null){
            System.out.println("Empty tree!");
            return;
        }
        queue.add(tmp_root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            map.put(node.value, new ArrayList<>());
            if(node.left != null){
                queue.add(node.left);
                map.get(node.value).add(node.left.value);
                if(node.left.value == target){
                    break;
                }
            }
            if(node.right != null){
                queue.add(node.right);
                map.get(node.value).add(node.right.value);
                if(node.right.value == target){
                    break;
                }
            }
        }
        if(queue.isEmpty()){
            System.out.println("Element not found");
            return;
        }
        System.out.print(target + "->");
        while(!rootFound){
            for(int i: map.keySet()){
                if(map.get(i).contains(target)){
                    System.out.print(i+"->");
                    target = i;
                    break;
                }
                if(target == root.value){
                    rootFound = true;
                    break;
                }

            }
        }
    }

    public void dls(int target){

    }

    public void dfs(int target){
        Stack<Node> path = new Stack<>();
        dfs(root, path, target);
    }

    private void dfs(Node node, Stack<Node> path, int target){
        if(node == null){
            return;
        }

        if(node.value == target){
            System.out.print(node.value + "->");
            while(!path.empty()){
                System.out.print(path.pop().value + "->");
            }
            System.out.println();
            System.exit(1);
        }

        path.push(node);
        dfs(node.left, path, target);
        dfs(node.right, path, target);
        path.pop();
    }

    public void display(){
        display(root, 0);
    }

    public void display(Node node, int level){
        if(node == null){
            return;
        }
        display(node.right, level+1);
        //level 0 means we are at the root
        if(level != 0){
            for(int i =0; i< level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->" +node.value);
        }else{
            System.out.println(node.value);
        }
        display(node.left, level+1);
    }

    public Node buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        int root = preorder[0];
        int index = 0;
        Node root_node = new Node(root);
        for(int i = 0; i<inorder.length; i++){
            if(root == inorder[i]){
                index = i;
                break;
            }
        }
        root_node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        root_node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));
        return root_node;
    }

    public String serialize(Node root) {
        if(root == null){
            return ".";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.value);
        stringBuilder.append(serialize(root.left));
        stringBuilder.append(serialize(root.right));
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty() || index >= data.length() || data.charAt(index) == '.') {
            index++;
            return null;
        }

        Node node = new Node(data.charAt(index)-'0');
        index++;
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node (int value){
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree  = new BinaryTree();
        tree.root = tree.deserialize("1..");

    }
}

