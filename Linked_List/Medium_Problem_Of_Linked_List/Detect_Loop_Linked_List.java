package Medium_Problem_Of_Linked_List;

//  GFG Problem : Detect Loop in linked list
//  Link : https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

//  LeetCode Problem : 141. Linked List Cycle
//  Link : https://leetcode.com/problems/linked-list-cycle

import java.util.HashSet;

public class Detect_Loop_Linked_List {
    static void main(String[] args) {

        int[] values = {1, 2, 3, 4, 5, 3, 4, 5};

        Node head = createList(values);

        System.out.println("Brute Force Approach : " + detectLoopBrute(head));

        System.out.println("Optimal Approach : " + detectLoopOptimal(head));

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

//    Function to Create a Linked List
    public static Node createList (int[] values){
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++){
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Function to Print a Linked List
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Brute Force Approach :
    public static boolean detectLoopBrute(Node head) {
        HashSet<Node> visited = new HashSet<>();

        Node temp = head;

        while (temp != null){
            if (visited.contains(temp)){
                return true;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static boolean detectLoopOptimal(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
