package Doubly_Linked_List;

//  GFG Problem : Insertion in a Doubly Linked List
//  Link : https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1

//  The above GFG Problem states that to insert a given node x "after" the kth node and in 0 - based indexing

public class Insertion_In_Doubly_Linked_List {
    static void main(String[] args) {

        int[] values = {10, 20, 30, 40};

        int x = 5;

        int k = 3;

        Node head = createList(values);

        System.out.print("Insert Before Head : ");
        printList(insertBeforeHead(head, x));

        head = createList(values);
        System.out.print("Insert Before Tail : ");
        printList(insertBeforeTail(head, x));

        head = createList(values);
        System.out.print("Insert Before Kth Node : ");
        printList(insertBeforeKthNode(head, k, x));

    }

//    Setup :
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

//    Function to create Doubly Linked List
    public static Node createList(int[] values){
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++){
            Node newNode = new Node(values[i]);
            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }
        return head;
    }

//    Function tp print the Doubly Linked List
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    1. Insert Before Head
    public static Node insertBeforeHead(Node head, int x){
        Node newNode = new Node(x);

        if (head == null){
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;

        return newNode;
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)

//    2. Insert Before Tail
    public static Node insertBeforeTail(Node head, int x){
        if (head == null){
            return new Node(x);
        }
        Node tail = head;

        while (tail.next != null){
            tail = tail.next;
        }
        Node newNode = new Node(x);

        newNode.prev = tail.prev;
        newNode.next = tail;

        tail.prev.next = newNode;
        tail.prev = newNode;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    3. Insert Before the Kth node
    public static Node insertBeforeKthNode(Node head, int k, int x){
        if (head == null || k <= 0){
            return head;
        }
        Node temp = head;

        for (int i = 1; i < k; i ++){
            if (temp == null){
                return head;
            }
            temp = temp.next;
        }
        if (temp == null){
            return head;
        }
//        Insert Before head
        if (temp.prev == null){
            Node newNode = new Node(x);

            newNode.next = temp;
            temp.prev = newNode;

            return newNode;
        }

        Node newNode = new Node(x);

        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

}
