package Medium_Problem_Of_Linked_List;

//  LeetCode Problem : 328. Odd Even Linked List
//  Link : https://leetcode.com/problems/odd-even-linked-list

public class Segregate_Even_Odd_Nodes_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        printList(segregateEvenOdd(head));
    }

//    Setup :
    static class Node{
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
    public static Node segregateEvenOdd(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
