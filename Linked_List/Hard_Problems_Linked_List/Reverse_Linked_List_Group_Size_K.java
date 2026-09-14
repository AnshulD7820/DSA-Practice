//  GFG Problem : Linked List Group Reverse
//  Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

//  LeetCode Problem : 25. Reverse Nodes in k-Group
//  Link : https://leetcode.com/problems/reverse-nodes-in-k-group

package Hard_Problems_Linked_List;

public class Reverse_Linked_List_Group_Size_K {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        Node head = createList(values);

        printList(reverseKGroup(head, k));
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

//    Optimal Approach : Recursive Approach
    public static Node reverseKGroup (Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }

//        Check whether k nodes are available
        Node temp = head;

        for (int i = 0; i < k ; i ++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

//        Reverse first k nodes
        Node prev = null;
        Node curr = head;

        for (int i = 0; i < k; i ++) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

//        Head is now the last node of this reversed group
        head.next = reverseKGroup(curr, k);

        return prev;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n / k)
//                          Because of recursive stack
}
