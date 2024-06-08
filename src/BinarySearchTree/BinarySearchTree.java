package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {


    Node root;

    public BinarySearchTree(){

    }

    public void insert(int value){
        root = insert(root, value);
    }

    public Node insert(Node node, int value){
        if(node == null){
            Node node1 = new Node(value);
            return node1;
        }

        if(node.value > value){
            node.leftChild = insert(node.leftChild, value);
        }
        if(node.value < value){
            node.rightChild = insert(node.rightChild, value);
        }

        node.height  = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        return node;
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.leftChild, "Left child of "+node.getValue()+": ");
        display(node.rightChild, "right child of "+node.getValue()+": ");
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.leftChild)- height(node.rightChild)) <= 1 && balanced(node.leftChild) && balanced(node.rightChild);
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        this.insert(nums[mid]);
        this.populateSorted(nums, start, mid-1);
        this.populateSorted(nums, mid+1, end);
    }

    public void populate(int[] nums){
        for(int i: nums){
            insert(i);
        }
    }

    public int kthSmallest(Node root, int k){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        int count = 0;
        while((!stack.isEmpty() || current != null) && count < k){
            while(current != null){
                stack.push(current);
                current = current.leftChild;
            }
            Node  node = stack.pop();
            result.add(current.value);
            count++;
            current = current.rightChild;
        }

        return result.get(k-1);
    }

    public static class Node{
        int value;
        int     height;
        Node rightChild;
        Node leftChild;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        bst.populateSorted(nums);
        bst.display();
    }
}
