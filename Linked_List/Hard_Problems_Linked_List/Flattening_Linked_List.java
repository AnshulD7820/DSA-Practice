//  GFG Problem : Flattening a Linked List
//  Link : https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

package Hard_Problems_Linked_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flattening_Linked_List {
    static void main(String[] args) {
        Node head = createList();

        System.out.print("Brute Force Approach : ");
        printList(flatteningLLBrute(head));

        System.out.print("Optimal Approach : ");
        printList(flatteningLLOptimal(head));
    }

//    Setup :
    static class Node {
        int data;
        Node next;
        Node child;

        Node (int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

//    Create a Linked List using next Pointer
    public static Node createNextList (int[] values) {
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Create a Linked List using child Pointer
    public static Node createChildList (int[] values) {
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            temp.child = new Node(values[i]);
            temp = temp.child;
        }
        return head;
    }

//    Create the Complete Structure
    public static Node createList() {
//        Top - level list
        Node head = createNextList(new int[] {5, 10, 19, 28});
//        Child list of 5
        head.child = createChildList(new int[] {7, 8, 30});
//        Child list of 19
        head.next.next.child = createChildList(new int[] {22, 50});
//        Child list of 28
        head.next.next.next.child = createChildList(new int[] {35, 40, 45});

        return head;
    }

//    Print the Structure
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");

//            Print Child List if Exits
            if (temp.child != null) {
                System.out.print(" -> child: ");

                Node childTemp = temp.child;

                while (childTemp != null) {
                    System.out.print(childTemp.data + " ");
                    childTemp = childTemp.child;
                }
                System.out.println();
            }
            temp = temp.next;
        }
    }

//    Brute Force Approach : { ArrayList }
    public static Node flatteningLLBrute (Node head) {
        List<Integer> arr = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            Node t2 = temp;
            while (t2 != null) {
                arr.add(t2.data);
                t2 = t2.child;
            }
            temp = temp.next;
        }
        Collections.sort(arr);

        return convertArrToLL(arr);
    }
    public static Node convertArrToLL (List<Integer> arr) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int val : arr) {
            temp.child = new Node(val);
            temp = temp.child;
        }
        return dummy.child;
    }

//    Time Complexity : O(N x M) + O(N x M log(N x M)) + O(N x M)
//                      Where N -> Number of nodes along the next pointer
//                            M -> Number of nodes along the child pointer
//    Space Complexity : O(N x M) + O(N x M)

//    Optimal Approach :
    public static Node flatteningLLOptimal (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergeHead = flatteningLLOptimal(head.next);
        head = merge (head, mergeHead);

        return head;
    }

    public static Node merge (Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp.child = temp1;
                temp = temp1;
                temp1 = temp1.child;
            }
            else {
                temp.child = temp2;
                temp = temp2;
                temp2 = temp2.child;
            }
            temp.next = null;
        }

        if (temp1 != null) {
            temp.child = temp1;
        }
        else {
            temp.child = temp2;
        }

        if (dummy.child != null) {
            dummy.child.next = null;
        }
        return dummy.child;
    }

//    Time Complexity : O(M x N ^ 2)
//    Space Complexity : O(1)
}
