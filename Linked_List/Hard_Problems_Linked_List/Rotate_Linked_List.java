//  GFG Problem : Rotate a Linked List
//  Link : https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1

//  LeetCode Problem : 61. Rotate List
//  Link : https://leetcode.com/problems/rotate-list

package Hard_Problems_Linked_List;

public class Rotate_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int k = 2;

        Node head = createList(values);

        printList(rotateByKNode(head, k));
    }

//    Setup :
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

//    Function to Create Linked List
    public static Node createList (int[] values) {
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Function to Print Linked List
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Optimal Approach :
    public static Node rotateByKNode (Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

//        Find the length and tail;
        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length ++;
        }

//        Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

//        Find the new tail
        int steps = length - k;

        Node newTail = head;

        for (int i = 1; i < steps; i ++) {
            newTail = newTail.next;
        }

//        New Head
        Node newHead = newTail.next;

//        Break the list
        newTail.next = null;

//        Connect the old tail to the old head
        tail.next = head;

        return newHead;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

}
