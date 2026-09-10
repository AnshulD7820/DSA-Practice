//  GFG Problem : Sort Singly Linked List
//  Link : https://www.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1

//  LeetCode Problem : 148. Sort List
//  Link : https://leetcode.com/problems/sort-list

package Medium_Problem_Of_Linked_List;

import java.util.ArrayList;
import java.util.Collections;

public class Sort_Linked_List {
    static void main(String[] args) {
        int[] values = {2, 1, 4, 3, 5};

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(sortLLBrute(head));

        System.out.print("Optimal Approach : ");
        printList(sortLLOptimal(head));
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

//    Brute Force Approach :
    public static Node sortLLBrute (Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;

//        Store all the values from the linked list
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
//        Sort the array
        Collections.sort(arr);
//        Convert the array into linked list
        Node dummy = new Node(-1);
        Node tempDummy = dummy;

        for (int values : arr) {
            tempDummy.next = new Node(values);
            tempDummy = tempDummy.next;
        }
        return dummy.next;
    }

//    Time Complexity : O(n) + O(n log n) + O(n) ≈ O(n log n)
//    Space Complexity : O(n)

//    Optimal Approach : Merge Sort
//    Function to merge two sorted linked list
    public static Node merge (Node head1, Node head2) {
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

            if (temp1 != null) {
                temp.next = temp1;
            }
            else {
                temp.next = temp2;
            }
        }
        return dummy.next;
    }

//    Function to find middle of linked list
    public static Node findMiddle (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node sortLLOptimal (Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddle(head);

        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = sortLLOptimal(left);
        right = sortLLOptimal(right);

        return merge(left, right);
    }

//    Time Complexity : O(n log n)
//    Space Complexity : O(log n)
//                      { because of the recursion stack }
}
