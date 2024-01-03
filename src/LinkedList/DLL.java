package LinkedList;

import OOP.Parent;

public class DLL {

    private Node head;

    private Node tail;

    private int size;

    public DLL(){
        this.size = 0;
    }

    public void insert(int index, int value){
        if(index == 0){
            insertFirst(value);
        }else if(index == size){
            insertLast(value);
        }else if(index > size){
            System.out.println("Index out of bounds");
        }else{
            Node node = new Node(value);
            Node tmp_head = head;
            for(int i=0; i<index-1; i++){
                tmp_head = tmp_head.next;
            }
            node.next = tmp_head.next;
            tmp_head.next.previous = node;
            tmp_head.next = node;
            node.previous = tmp_head;
            size++;
        }

    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            head.previous = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertLast(int value){
        Node node = new Node(value);
        if(size == 0){
            insertFirst(value);
        }else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public void deleteFirst(){
        if(size == 0){
            System.out.println("Already empty!");
        }else if(size == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void deleteLast(){
        if(size == 0){
            System.out.println("Already empty");
        }else if(size == 1){
            deleteFirst();
        }else{
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void delete(int index){
        if(index == 0){
            deleteFirst();
        }else if(index == size-1){
            deleteLast();
        }else if(index >= size){
            System.out.println("Index out of bounds");
        }else{
            Node tmp_head = head;
            for(int i=0; i<index-1; i++){
                tmp_head = tmp_head.next;
            }
            Node node = tmp_head.next;
            tmp_head.next = node.next;
            node.next.previous = tmp_head;
            size--;
        }
    }

    public void printLinkedList(){
        Node tmp_head = head;
        while(tmp_head != null){
            System.out.print(tmp_head.value + "->");
            tmp_head = tmp_head.next;
        }
        System.out.println();
    }

    public void printLinkedListReverse(){
        Node tmp_tail = tail;
        while(tmp_tail != null){
            System.out.print(tmp_tail.value + "->");
            tmp_tail = tmp_tail.previous;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
//        dll.insertFirst(5);
//        dll.insertLast(6);
//        dll.insertFirst(7);
//        dll.insertLast(8);
//        dll.insert(2, 9);
//        dll.insert(4, 10);
//        dll.insert(6, 11);
        dll.insertFirst(5);
        dll.insertFirst(6);
        dll.insert(2, 3);
        dll.insertLast(7);
        dll.insert(3, 4);
        dll.deleteLast();
        dll.delete(2);
        dll.printLinkedList();
        dll.printLinkedListReverse();
        System.out.println(dll.size);
    }

    private class Node{

        private int value;
        private Node next;

        private Node previous;

        public Node(int value){
            this.value = value;
        }
    }
}
