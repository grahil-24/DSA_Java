package BinaryTree;

import java.util.*;

public class BinaryTree {

    private Node root;
    public BinaryTree(){

    }

    public void populate(Scanner scanner){
        System.out.println("Enter value for root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node root){
        System.out.println("Do you want to create a left child for: "+root.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value for the left child of "+root.value);
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
        tree.populate(scanner);
        tree.bfsTarget(12);

    }
}

