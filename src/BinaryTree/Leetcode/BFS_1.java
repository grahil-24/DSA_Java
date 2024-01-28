package BinaryTree.Leetcode;

import BinaryTree.BinaryTree;

import java.util.*;

public class BFS_1 {

    private Node root;

    public BFS_1() {

    }

    public void populate(Scanner scanner) {
        System.out.println("Enter value for root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node root) {
        System.out.println("Do you want to create a left child for: " + root.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value for the left child of " + root.value);
            int value = scanner.nextInt();
            Node leftChild = new Node(value);
            root.left = leftChild;
            populate(scanner, root.left);
        }
        System.out.println("Do you want to create a right child for: " + root.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value for the right child of " + root.value);
            int value = scanner.nextInt();
            Node rightChild = new Node(value);
            root.right = rightChild;
            populate(scanner, root.right);
        }

    }

    public List<List<Integer>> bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(currentLevel);
        }
        return list;
    }

    public List<List<Node>> bfsNode() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Node>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(currentLevel);
        }
        return list;
    }

    public List<List<Integer>> bfsZigZag() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        boolean leftfirst = true;
        if (root == null) {
            return list;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (!leftfirst) {
                Collections.reverse(currentLevel);
                leftfirst = true;
            } else {
                leftfirst = false;
            }
            list.add(currentLevel);
        }
        return list;
    }

    public List<Double> averageOfLevels(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> avgLevels = new ArrayList<>();

        while (!queue.isEmpty()) {
            Double avg = 0.0;
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                avg += currentNode.value;
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            avgLevels.add(avg / levelSize);
        }
        return avgLevels;
    }

    public void bfsTarget(int target) {
        Node tmp_root = root;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean rootFound = false;
        if (tmp_root == null) {
            System.out.println("Empty tree!");
            return;
        }
        queue.add(tmp_root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            map.put(node.value, new ArrayList<>());
            if (node.left != null) {
                queue.add(node.left);
                map.get(node.value).add(node.left.value);
                if (node.left.value == target) {
                    break;
                }
            }
            if (node.right != null) {
                queue.add(node.right);
                map.get(node.value).add(node.right.value);
                if (node.right.value == target) {
                    break;
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println("Element not found");
            return;
        }
        System.out.print(target + "->");
        while (!rootFound) {
            for (int i : map.keySet()) {
                if (map.get(i).contains(target)) {
                    System.out.print(i + "->");
                    target = i;
                    break;
                }
                if (target == root.value) {
                    rootFound = true;
                    break;
                }

            }
        }
    }

    public List<List<Integer>> levelOrderTraversal2() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(1, currentLevel);
        }
        return list;
    }

    public void display() {
        display(root, 0);
    }

    public void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        //level 0 means we are at the root
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        display(node.left, level + 1);
    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> bfs = this.bfs();
        for (List<Integer> arr : bfs) {
            res.add(arr.getLast());
        }
        return res;
    }

    public boolean isCousins(Node root, int x, int y) {
        boolean areCousins = false;
        int y_parent = -1;
        int y_depth;
        int x_parent = -1;
        int x_depth;

        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        if (root.value == x) {
            x_parent = root.value;
            x_depth = depth;
        }
        if (root.value == y) {
            y_parent = root.value;
            y_depth = depth;
        }
        while (!queue.isEmpty() && ((x_parent == -1) || (y_parent == -1))) {
            Node node = queue.poll();
        }
        return areCousins;
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        List<List<Node>> list = this.bfsNode();
        int length = list.size();
        int i = 0;
        while(i < length){
            List<Node> list2 = list.get(i);
            int j = 0;
            int length2 = list2.size();
            while(j < length2 - 1){
                list2.get(j).right = list2.get(j+1);
                j++;
            }
            list2.get(j).right = null;
            i++;
        }
        return root;
    }

    public Node connect2(Node node) {
        if(node.left == null && node.right == null){
            return node;
        }

        if(node.left != null){
            Node leftNode = connect2(node.left);
        }
        if(node.right != null){
            Node rightNode = connect2(node.right);
        }

        return node;
    }



    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
//        BFS_1 bfs = new BFS_1();
//        bfs.populate(new Scanner(System.in));
//        bfs.connect(bfs.root);
    }
}

