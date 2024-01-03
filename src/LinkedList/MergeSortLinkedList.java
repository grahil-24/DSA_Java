package LinkedList;

import java.util.List;

public class MergeSortLinkedList {


    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return mergeLinkedLists(left, right);
    }

    public ListNode mergeLinkedLists(ListNode first, ListNode second) {
        ListNode f = first;
        ListNode s = second;
        ListNode ans = new ListNode();
        ListNode tail = ans;


        while (f != null && s != null) {
            if (f.val < s.val) {
                tail.next = f;
                f = f.next;
                tail = tail.next;
            } else {
                tail.next = s;
                s = s.next;
                tail = tail.next;
            }
        }

        tail.next = (f != null) ? f : s;
        return ans.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



