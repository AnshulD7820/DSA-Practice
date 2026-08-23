package Medium_Problem_Of_Linked_List;

//  GFG Problem : Cycle Length in Linked List
//  Link : https://www.geeksforgeeks.org/problems/find-length-of-loop/1

import java.util.HashSet;

public class Length_Loop_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        System.out.println("Brute Force Approach : " + lengthLoopBrute(head));

        System.out.println("Optimal Approach : " + lengthLoopOptimal(head));

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
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Brute Force Approach : {HashSet}
    public static int lengthLoopBrute (Node head) {
        HashSet<Node> visited = new HashSet<>();

        Node temp = head;

        while (temp != null) {
            if (visited.contains(temp)) {
                Node start = temp;
                int count = 1;

                temp = temp.next;

                while (temp != start) {
                    count ++;
                    temp = temp.next;
                }
                return count;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return 0;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach : {Tortoise & Hare}
    public static int lengthLoopOptimal (Node head) {
        Node slow = head;
        Node fast = head;
//        Detect a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
//                Count Cycle Length
                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count ++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return 0;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
