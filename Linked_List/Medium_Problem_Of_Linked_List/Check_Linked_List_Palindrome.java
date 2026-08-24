package Medium_Problem_Of_Linked_List;

//  GFG Problem : Palindrome Linked List
//  Link : https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1

//  LeetCode Problem : 234. Palindrome Linked List
//  Link : https://leetcode.com/problems/palindrome-linked-list

import java.util.ArrayList;

public class Check_Linked_List_Palindrome {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 2, 1};

        Node head = createList(values);

        System.out.println("Brute Force Approach : " + checkPalindromeBrute(head));

        System.out.println("Optimal Approach : " + checkPalindromeOptimal(head));

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
    public static boolean checkPalindromeBrute(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (!arr.get(left).equals(arr.get(right))) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static boolean checkPalindromeOptimal(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

//        STEP 1 : FIND THE MIDDLE
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

//        STEP 2 : FIND START OF SECOND HALF
        Node secondHalf;

        if (fast == null) {
//            Even length
            secondHalf = slow;
        }
        else{
//            Odd length
            secondHalf = slow.next;
        }

//        STEP 3 : REVERSE THE SECOND HALF
        secondHalf = reverse(secondHalf);

//        STEP 4 : COMPARE FIRST HALF AND SECOND HALF
        Node first = head;
        Node second = secondHalf;

        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

//        STEP 5 : RESTORE THE SECOND HALF
        secondHalf = reverse(secondHalf);

        return true;
    }

    private static Node reverse(Node head) {
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
