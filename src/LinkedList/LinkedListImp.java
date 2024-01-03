package LinkedList;

public class LinkedListImp {
    private Node head;
    private Node tail;

    private int size;

    public LinkedListImp(){
        this.size = 0;
    }

    public void printList(){
        Node node = head;
        while(node!= null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }

    public void insert(int val, int index){
        if(index == size){
            insertLast(val);
        }else if(index == 0){
            insertFirst(val);
        }else if(index > size){
            System.out.println("Index out of bounds");
            return;
        }else{
            Node temp_head = head;
            Node node = new Node(val);
            for(int i=0; i<index-1; i++){
                temp_head = head.next;
            }
            node.next = temp_head.next;
            temp_head.next = node;
            size++;
        }
    }

    public void insertLast(int value){
        if(size == 0){
            insertFirst(value);
        }else{
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }

    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void deleteFirst(){
        if(size == 0){
            return;
        }
        if(size == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        size--;
    }

    public void deleteLast(){
        if(size == 0){
            return;
        }
        if(size == 1){
            deleteFirst();
        }else{
            Node temp_head = head;
            while(temp_head.next != tail){
                temp_head = temp_head.next;
            }
            temp_head.next = null;
            size--;
        }
    }

    public int get(int index){
        if(index >= size){
            System.out.println("Index out of bounds");
            return -1;
        }else{
            Node tmp_head = head;
            for(int i =0; i<index; i++){
                tmp_head = tmp_head.next;
            }
            return tmp_head.value;
        }
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(node, val);
            size++;
            return temp;
        }
        node.next = insertRec(val, --index, node.next);
        return node;
    }

    private class Node {


        private Node next;
        private int value;

        public Node(int val) {
            this.value = val;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        LinkedListImp ll = new LinkedListImp();
        ll.insertLast(5);
//        ll.insertLast(6);
        ll.insertFirst(7);
        ll.insertFirst(4);
        ll.insertFirst(6);
        ll.insertRec(9, 2);
        System.out.println(ll.size);
        ll.printList();
    }


    public void removeDuplicates(){
        Node node = head;

        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public void mergeLinkedLists(LinkedListImp first, LinkedListImp second){
        Node f = first.head;
        Node s = second.head;

        LinkedListImp ans = new LinkedListImp();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
    }

    public boolean hasCycle(LinkedListImp head){
        Node slow_ptr = head.head;
        Node fast_ptr = head.head;

        while(fast_ptr != null & fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if(fast_ptr == slow_ptr){
                return true;
            }
        }
        return false;
    }

    public int cycleLength(LinkedListImp head){
        Node slow_ptr = head.head;
        Node fast_ptr = head.head;
        int length = 0;
        while(fast_ptr != null & fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if(fast_ptr == slow_ptr){
                slow_ptr = slow_ptr.next;
                length++;
                while(fast_ptr != slow_ptr){
                    slow_ptr = slow_ptr.next;
                    length++;
                }
                return length;
            }
        }
        return -1;
    }
}


