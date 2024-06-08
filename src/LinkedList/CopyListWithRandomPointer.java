package LinkedList;

public class CopyListWithRandomPointer {

    Node head;

    public Node createLinkedList(int[] arr){
        if(head == null){
            head = new Node(arr[0]);
        }
        Node temp = head;
        for(int i = 1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int hashCode(){
            return this.val;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
//
//        int[] a = new int[];
//        a.length
    }
}
