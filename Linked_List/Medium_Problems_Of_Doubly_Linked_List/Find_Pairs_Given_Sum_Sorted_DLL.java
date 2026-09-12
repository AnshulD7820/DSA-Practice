//  GFG Problem : Pair Sum in Sorted Doubly Linked List
//  Link : https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

package Medium_Problems_Of_Doubly_Linked_List;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_Pairs_Given_Sum_Sorted_DLL {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        int target = 7;

        Node head = createList(values);

        System.out.println(findPairs(head, target));
    }

//    Setup :
    static class Node {
        int data;
        Node prev;
        Node next;

        Node (int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

//    Function to Create Doubly Linked List
    public static Node createList (int[] values) {
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            Node newNode = new Node(values[i]);

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }
        return head;
    }

//    Function to Print Doubly Linked List
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Optimal Approach : Two Pointers
    public static ArrayList<ArrayList<Integer>> findPairs (Node head, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (head == null || head.next == null) {
            return ans;
        }

        Node left = head;
        Node right = head;

//        Find Tail
        while (right.next != null) {
            right = right.next;
        }

//        two pointer approach
        while (left != right && left != right.next) {
            int sum = left.data + right.data;

            if (sum == target) {
                ans.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            }
            else if (sum < target) {
                left = left.next;
            }
            else {
                right = right.prev;
            }
        }
        return ans;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
