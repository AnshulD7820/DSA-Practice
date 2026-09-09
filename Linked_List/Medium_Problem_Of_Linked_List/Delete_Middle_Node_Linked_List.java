package Medium_Problem_Of_Linked_List;

//  GFG Problem : Delete Middle of Linked List
//  Link : https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1

//  LeetCode Problem : 2095. Delete the Middle Node of a Linked List
//  Link : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

public class Delete_Middle_Node_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(removeMiddleNodeBrute(head));

        head = createList(values);
        System.out.print("Optimal Approach : ");
        printList(removeMiddleNodeOptimal(head));
    }

//    Setup :
    static class Node {
       int data;
       Node next;

       Node  (int data) {
           this.data = data;
           this.next = null;
       }
    }

//    Function to Create a Linked List
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
    public static Node removeMiddleNodeBrute (Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        int count = 0;
        Node temp = head;
//        Count the Length of Linked List
        while (temp != null) {
            count ++;
            temp = temp.next;
        }

        int res = count / 2;
        temp = head;
//        Traverse to delete the middle node
        while (temp != null) {
            res --;
            if (res == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n + n / 2)
//    Space Complexity : O(1)

//    Optimal Approach : Two Pointer (Tortoise and Hare Method)
    public static Node removeMiddleNodeOptimal (Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }

//    Time Complexity : O(n / 2)
//    Space Complexity : O(1)
}
