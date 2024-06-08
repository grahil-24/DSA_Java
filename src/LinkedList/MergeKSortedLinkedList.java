package LinkedList;

public class MergeKSortedLinkedList {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resHead = null;
        for(int i = 0; i<lists.length; i++){
            resHead = mergeLinkedList(resHead, lists[i]);
        }
        return resHead;
    }

    public ListNode mergeLinkedList(ListNode list1, ListNode list2){
        ListNode f = list1;
        ListNode s = list2;
        ListNode ans = new ListNode();
        ListNode tail = ans;

        while(f != null || s != null){
            if(f.val < s.val){
                tail.next = f;
                f = f.next;
                tail = tail.next;
            }else{
                tail.next = s;
                s = s.next;
                tail = tail.next;
            }
        }
        tail.next = (f != null) ? f : s;
        return ans.next;
    }
}
