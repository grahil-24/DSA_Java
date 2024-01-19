package LinkedList;

import java.util.List;

public class SumOfTwoLinkedList {



    public ListNode2 addTwoNumbers(ListNode l1, ListNode2 l2){
        ListNode2 l3_head = null;
        ListNode2 l3_tail = null;
        boolean carry_over = false;

        while(l1 != null && l2 != null){
            int res = l1.val + l2.val;
            if(carry_over){
                res = res + 1;
            }
            if(res >= 10) {
                res = res % 10;
                carry_over = true;
            }else{
                if(carry_over){
                    carry_over = false;
                }
            }
            ListNode2 l = new ListNode2(res);
            if(l3_head == null){
                l3_head = l;
                l3_tail = l;
            }else{
                l3_tail.next = l;
                l3_tail = l;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int res = l1.val;
            if(carry_over){
                res += 1;
            }
            if(res >= 10){
                res = res % 10;
                carry_over = true;
            }else{
                if(carry_over){
                    carry_over = false;
                }
            }
            ListNode2 l = new ListNode2(res);
            l3_tail.next = l;
            l3_tail = l;
            l1 = l1.next;
        }

        while(l2 != null){
            int res = l2.val;
            if(carry_over){
                res += 1;
            }
            if(res >= 10){
                res = res % 10;
                carry_over = true;
            }else{
                if(carry_over){
                    carry_over = false;
                }
            }
            ListNode2 l = new ListNode2(res);
            l3_tail.next = l;
            l3_tail = l;
            l2 = l2.next;
        }

        if(carry_over){
            ListNode2 l = new ListNode2(1);
            l3_tail.next = l;
            l3_tail = l;
        }

        return l3_head;

    }

    public static void main(String[] args) {

    }
}

class ListNode2{
    int val;
    ListNode2 next;
    ListNode2(int val) { this.val = val; }
}
