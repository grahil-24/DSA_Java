package LinkedList;

import java.util.List;

public class ReversedLinkedList {

    Node head;
    Node tail;

    public void revereseList(Node node){
        if(node.next != null){
            head = tail;
            return;
        }

        revereseList(head.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

//    public ListNode reverseSubList(ListNode head, int left , int right){
//
//    }


    class Node{

        private int value;
        private Node next;
    }
}

