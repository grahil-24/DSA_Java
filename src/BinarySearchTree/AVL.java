package BinarySearchTree;

public class AVL {

    Node root;

    public AVL(){

    }

    public void insert(int value){
        root = insert(root, value);
    }

    public Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(node.value > value){
            node.leftChild = insert(node.leftChild, value);
        }
        if(node.value < value){
            node.rightChild = insert(node.rightChild, value);
        }

        node.height  = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        return rotate(node);
    }

    public Node rotate(Node node){

        if(height(node.leftChild) - height(node.rightChild) > 1){
            //1st case - left-left case
            if(height(node.leftChild.leftChild) - height(node.leftChild.rightChild) > 0){
                return rightRotate(node);
//
            }
            //2nd case - left-right case
            if(height(node.leftChild.leftChild) - height(node.leftChild.rightChild) < 0){
                node.leftChild = leftRotate(node.leftChild);
                return rightRotate(node);
            }
        }
        if(height(node.leftChild) - height(node.rightChild) < -1){
            //3rd case - right-right case
            if(height(node.rightChild.leftChild) - height(node.rightChild.rightChild) < 0){
                return leftRotate(node);
            }
            //4th case - right-left case
            if(height(node.rightChild.leftChild) - height(node.rightChild.rightChild) > 0){
                node.rightChild = rightRotate(node.rightChild);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node node){
        Node child = node.leftChild;
        node.leftChild = child.rightChild;
        child.rightChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild))+1;
        child.height = Math.max(height(child.leftChild), height(child.rightChild))+1;
        return child;
    }

    public Node leftRotate(Node node){
        Node child = node.rightChild;
        node.rightChild = child.leftChild;
        child.leftChild = node;

        node.height = Math.max(height(node.leftChild), height(node.rightChild))+1;
        child.height = Math.max(height(child.leftChild), height(child.rightChild))+1;
        return child;
    }




    public int height(){
        return height(root);
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

    public void populate(int[] nums){
        for(int i: nums){
            insert(i);
        }
    }

    public static class Node{
        int value;
        int height;
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
        AVL tree = new AVL();
        for(int i  =0; i<20; i++){
            tree.insert(i);
        }
        System.out.println(tree.height());
        tree.display();
    }
}
