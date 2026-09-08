package Medium_Problem_Of_Linked_List;

//  GFG Problem : Kth from End of Linked List
//  Link : https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

//  LeetCode Problem : 19. Remove Nth Node From End of List
//  Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list


public class Remove_Nth_Node_From_End_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int n = 2;

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(removeNthNodeBrute(head,n));

        head = createList(values);
        System.out.print("Optimal Approach : ");
        printList(removeNthNodeOptimal(head, n));
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
    public static Node removeNthNodeBrute (Node head, int n) {
        if (head == null) {
            return null;
        }

//        Count the Length of Linked List
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count ++;
            temp = temp.next;
        }

//        If n equals total nodes -> Remove head
        if (count == n) {
            return head.next;
        }

//        Calculate position from start
        int res = count - n;
        temp = head;

//        Traverse the node before target
        while (temp != null) {
            res --;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

//    Time Complexity : O(l) + O(l - n)
//    Space Complexity : O(1)

    public static Node removeNthNodeOptimal (Node head , int n) {
//        Create a Dummy Node
        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

//        Move Fast n steps ahead
        for (int i = 1; i <= n; i ++) {
            fast = fast.next;
        }

//        Move both fast and slow until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

//        Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
