//  GFG Problem : Merge two sorted linked lists
//  Link : https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1

//  LeetCode Problem : 21. Merge Two Sorted Lists
//  Link : https://leetcode.com/problems/merge-two-sorted-lists

package Medium_Problem_Of_Linked_List;

import java.util.ArrayList;
import java.util.Collections;

public class Merge_Two_Sorted_Linked_List {
    static void main(String[] args) {
        int[] values1 = {1, 3, 5};
        int[] values2 = {2, 4, 6};

        Node head1 = createList(values1);
        Node head2 = createList(values2);

        System.out.print("Brute Force Approach : ");
        printList(mergeTwoSortedLLBrute(head1, head2));

        System.out.print("Optimal Approach : ");
        printList(mergeTwoSortedLLOptimal(head1, head2));
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
            System.out.print(temp.data +  " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Brute Force Approach :
    public static Node mergeTwoSortedLLBrute (Node head1, Node head2) {
        ArrayList<Integer> arr = new ArrayList<>();

        Node temp1 = head1;
        Node temp2 = head2;
//        Store the values from the first linked list
        while (temp1 != null) {
            arr.add(temp1.data);
            temp1 = temp1.next;
        }
//        Store the values from the second linked list
        while (temp2 != null) {
            arr.add(temp2.data);
            temp2 = temp2.next;
        }
//        Sort the array
        Collections.sort(arr);

//        Convert the array into linked list
        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int value : arr) {
            temp.next = new Node(value);
            temp = temp.next;
        }
        return dummy.next;
    }

//    Time Complexity : O(n + m) + O(log (n + m))
//                      Where : n -> length of first linked list
//                              m -> length of second linked list
//    Space Complexity : O(n + m)

//    Optimal Approach :
    public static Node mergeTwoSortedLLOptimal (Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        else{
            temp.next = temp2;
        }
        return dummy.next;
    }

//    Time Complexity : O(n + m)
//                      Where n -> length of first linked list
//                            m -> length of second linked list
//    Space Complexity : O(1)
}
