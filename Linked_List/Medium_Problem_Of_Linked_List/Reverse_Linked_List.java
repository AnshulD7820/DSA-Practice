package Medium_Problem_Of_Linked_List;

//  GFG Problem : Reverse a Linked List
//  Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1

//  LeetCode Problem : 206. Reverse Linked List
//  Link : https://leetcode.com/problems/reverse-linked-list

public class Reverse_Linked_List {
    static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        Node head = createList(values);

        System.out.print("Reverse a Linked List : ");
        printList(reverseLL(head));

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
    public static Node createList (int[] values){
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++){
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Function to Print Linked List
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Approach :
    public static Node reverseLL (Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
