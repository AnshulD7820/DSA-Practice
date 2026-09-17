//  GFG Problem : Clone List with Next and Random
//  Link : https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

//  LeetCode Problem : 138. Copy List with Random Pointer
//  Link : https://leetcode.com/problems/copy-list-with-random-pointer

package Hard_Problems_Linked_List;

import java.util.HashMap;
import java.util.HashSet;

public class Clone_Linked_List_Random_Next_Pointer {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        System.out.println("Brute Force Approach : ");
        printList(cloneLLBrute(head));

        System.out.println();

        System.out.println("Optimal Approach : ");
        printList(cloneLLOptimal(head));
    }

//    Setup :
    static class Node {
        int data;
        Node next;
        Node random;

        Node (int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

//    Function to create a linked list
    public static Node createList (int[] values) {
        Node[] nodes = new Node[values.length];

//        Create all nodes
        for (int i = 0; i < values.length; i ++) {
            nodes[i] = new Node(values[i]);
        }

//        Connect next pointer
        for (int i = 0; i < values.length - 1; i ++) {
            nodes[i].next = nodes[i + 1];
        }

//        Connect random pointer
        nodes[0].random = nodes[2];
        nodes[1].random = nodes[4];
        nodes[2].random = nodes[0];
        nodes[3].random = nodes[2];
        nodes[4].random = nodes[1];

        return nodes[0];
    }

//    Function to print the linked list
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> "
                    + (temp.next != null ? temp.next.data : "null")
                    + " | Random : "
                    + (temp.random != null ? temp.random.data : "null"));

        System.out.println();

        temp = temp.next;
        }
    }

//    Brute Force Approach : { HashMap }
    public static Node cloneLLBrute (Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
//        Step 1 : Create Clone of Every Node
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }

//        Step 2 : Connect random and next pointer
        temp = head;

        while (temp != null) {
            Node clone = map.get(temp);

            clone.next = map.get(temp.next);
            clone.random = map.get(temp.random);

            temp = temp.next;
        }
        return map.get(head);
    }

//    Time Complexity : O(n) + O(n) ~ O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static Node cloneLLOptimal (Node head) {
        if (head == null) {
            return null;
        }

//        STEP 1 : Insert Clone After Every Original Node
        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.data);

            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

//        STEP 2 : Connect the Random Pointer
        temp = head;

        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }
            else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }

//        STEP 3 : Separate Original and Clone List
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

//    Time Complexity : O(3n) ~ O(n)
//    Space Complexity : O(1)
}
