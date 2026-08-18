package Doubly_Linked_List;

//  GFG Problem : Reverse a Doubly Linked List
//  Link : https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1

public class Reverse_Doubly_Linked_List {
    static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        Node head = createList(values);
        System.out.print("Reverse Doubly Linked List : ");
        printList(reverseDLL(head));

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

//    Function to create a doubly linked list
    public static Node createList(int[] values){
        Node head = new Node(values[0]);

        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            Node newNode = new Node(values[i]);

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }
        return head;
    }

//    Function to print doubly linked list
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Optimal Approach : Swapping
    public static Node reverseDLL(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node temp = head;
        Node newHead = null;

        while (temp != null){
//            Swap prev and next
            Node swap = temp.prev;
            temp.prev = temp.next;
            temp.next = swap;

//            New head :
            newHead = temp;
//            Move to the next node in the original list
            temp = temp.prev;
        }
        return newHead;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
