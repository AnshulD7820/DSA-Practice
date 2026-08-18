package Singly_Linked_List;
//  GFG Problem : Delete Head of Linked List
//  Link : https://www.geeksforgeeks.org/problems/delete-head-of-linked-list/1

//  GFG Problem : Deletion at the end of a Linked List
//  Link : https://www.geeksforgeeks.org/problems/deletion-at-the-end-of-a-linked-list/1

//  LeetCode Problem : 237. Delete Node in a Linked List
//  Link : https://leetcode.com/problems/delete-node-in-a-linked-list

public class Deletion {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        int k = 3;

        int X = 4;

        Node head = createList(values);

        System.out.print("Delete the head of the Linked List : ");
        printList(deleteHead(head));

        head = createList(values);
        System.out.print("Delete the tail of the Linked List : ");
        printList(deleteTaiL(head));

        head = createList(values);
        System.out.print("Delete the Kth Element of the Linked List : ");
        printList(deleteKthElement(head, k));

        head = createList(values);
        System.out.print("Delete the Element with the value X : ");
        printList(deleteValX(head, X));

    }

//    Setup:
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//    Helper function to create a Linked List
    public static Node createList(int[] values){
        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i ++){
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

//    Function to print the linked list
    public static void printList(Node head){
        Node current = head;

        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

//    1. Deletion of the Head:
    public static Node deleteHead(Node head){
        if (head == null){
            return null;
        }
        return head.next;
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)

//    2. Deletion of the Tail:
    public static Node deleteTaiL(Node head){
        if (head == null || head.next == null){
            return null;
        }
        Node temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    3. Delete the kth Element:
    public static Node deleteKthElement(Node head, int k){
        if (head == null){
            return null;
        }
        if (k == 1){
            return head.next;
        }
        Node temp = head;

        for (int i = 1; i < k - 1; i ++){
            if (temp.next == null){
                return head.next;
            }
            temp = temp.next;
        }
        if (temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    4. Delete the element with value X
    public static Node deleteValX(Node head, int X){
        if (head == null){
            return null;
        }
        if (head.data == X){
            return head.next;
        }
        Node temp = head;

        while (temp.next != null){
            if (temp.next.data == X){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//.......................................................................................................................................................................................................................................................................................................................................................................

//    LeetCode 237 Solution :
//    public static void deleteNode(ListNode node){
//        node.val = node.next.val;
//        node.next = node.next.next;
//    }
}
