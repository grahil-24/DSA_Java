package LinkedList;

public class RemoveNthElementFromLast {

    ListNode head;

    public ListNode createLinkedList(int[] arr){
        if(head == null){
            head = new ListNode(arr[0]);
        }
        ListNode temp = head;
        for(int i = 1; i<arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow_ptr = head;
        ListNode fast_ptr = slow_ptr;

        while(fast_ptr != null){
            for(int i = 1; i<=n && fast_ptr != null; i++){
                fast_ptr = fast_ptr.next;
            }
            slow_ptr = slow_ptr.next;
        }

        if(slow_ptr == head){
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthElementFromLast obj = new RemoveNthElementFromLast();
        obj.createLinkedList(new int[]{1, 2, 3, 4, 5});
        obj.removeNthFromEnd(obj.head, 1);
        System.out.println(obj.head.val);
    }
}
