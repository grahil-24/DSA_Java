package BinaryTree;

import java.util.Scanner;

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
        tree.display();
    }
}

