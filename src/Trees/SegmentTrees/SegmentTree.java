package Trees.SegmentTrees;

public class SegmentTree {

    Node root;

    private class Node{
        Node left;
        Node right;
        int start_range;
        int end_range;
        int data;

        public Node(int start_range, int end_range){
            this.start_range = start_range;
            this.end_range = end_range;
        }

    }


    public SegmentTree(int[] arr){
        root = createSegmentTree(arr, 0, arr.length-1);
    }

    public Node createSegmentTree(int[] arr, int start, int end){
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end)/2;
        node.left = createSegmentTree(arr, start, mid);
        node.right = createSegmentTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int findSumOfRange(int start, int end){
        return findSumOfRange(start, end, root);
    }

    public int findSumOfRange(int start, int end, Node node){
        if(node.start_range >= start && node.end_range <= end){
            return node.data;
        }
        else if(node.start_range > end || node.end_range < start){
            return 0;
        }else{
            return this.findSumOfRange(start, end, node.left) + this.findSumOfRange(start, end, node.right);
        }
    }


    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int[]{3, 8, 6, 7, -2, -8, 4, 9});
        System.out.println(st.findSumOfRange(1, 6));
    }
}
