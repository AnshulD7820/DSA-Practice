package Medium_Problem_Of_Linked_List;

//  GFG Problem : First Node of Loop in Linked List
//  Link : https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1

//  LeetCode Problem : 142. Linked List Cycle II
//  Link : https://leetcode.com/problems/linked-list-cycle-ii

import java.util.HashSet;

public class Starting_Point_Loop_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(startingPointBrute(head));

        System.out.print("Optimal Approach : ");
        printList(startingPointOptimal(head));

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

//    Brute Force Approach : {HashSet}
    public static Node startingPointBrute (Node head) {
        HashSet<Node> visited = new HashSet<>();

        Node temp = head;

        while (temp != null) {
            if (visited.contains(temp)){
                return temp;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return null;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach : {Tortoise & Hare}
    public static Node startingPointOptimal (Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
