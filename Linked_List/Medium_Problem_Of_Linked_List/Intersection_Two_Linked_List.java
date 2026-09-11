//  GFG Problem : Intersection of Two Linked Lists
//  Link : https://www.geeksforgeeks.org/problems/intersection-of-two-linked-list/1
//  Solution of GFG Problem is given below because GFG has asked slightly different to what we have done

//  LeetCode Problem : 160. Intersection of Two Linked Lists
//  Link : https://leetcode.com/problems/intersection-of-two-linked-lists

package Medium_Problem_Of_Linked_List;

import java.util.HashSet;

public class Intersection_Two_Linked_List {
    static void main(String[] args) {
//        Common part
        Node common = new Node(8);
        common.next = new Node(5);
        common.next.next = new Node(9);

//        List 1 :
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = common;

//        List 2 :
        Node head2 = new Node(2);
        head2.next = new Node(7);
        head2.next.next = common;

        System.out.print("Brute Force Approach : ");
        printList(intersectionBrute(head1, head2));

        System.out.print("Optimal Approach : ");
        printList(intersectionOptimal(head1, head2));
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
    public static Node createList(int[] values) {
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

//    Brute Force Approach : HashSet
    public static Node intersectionBrute (Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }

        HashSet<Node> set = new HashSet<>();

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (set.contains(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

//    Time Complexity : O(n + m)
//                      Where : n -> length of first linked list
//                              m -> length of second linked list
//    Space Complexity : O(n)

//    Optimal Approach : { Two Pointer }
    public static Node intersectionOptimal (Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = head2;
            }
            else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = head1;
            }
            else {
                p2 = p2.next;
            }
        }
        return p1;
    }

//    Time Complexity : O(n + m)
//    Space Complexity : O(1)

//    GFG Problem Solution :
//public Node findIntersection(Node head1, Node head2) {
//    if (head1 == null || head2 == null) {
//        return null;
//    }
//
//    HashSet<Integer> set = new HashSet<>();
//
//    Node temp1 = head1;
//    Node temp2 = head2;
//
//    while (temp2 != null) {
//        set.add(temp2.data);
//        temp2 = temp2.next;
//    }
//
//    Node dummy = new Node(-1);
//    Node tail = dummy;
//
//    while (temp1 != null) {
//        if (set.contains(temp1.data)) {
//            tail.next = new Node(temp1.data);
//            tail = tail.next;
//        }
//        temp1 = temp1.next;
//    }
//    return dummy.next;
//}
}
