//  LeetCode Problem : 2. Add Two Numbers
//  Link : https://leetcode.com/problems/add-two-numbers

package Medium_Problem_Of_Linked_List;

public class Add_Two_Numbers_Linked_List {
    static void main(String[] args) {
        int[] values1 = {2, 4, 3};
        int[] values2 = {5, 6, 4};

        Node head1 = createList(values1);
        Node head2 = createList(values2);

        System.out.print("Optimal Approach : ");
        printList(addTwoNumberOptimal(head1, head2));

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

//    Optimal Approach :
    public static Node addTwoNumberOptimal (Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;

            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;

            current.next = new Node(digit);
            current = current.next;
        }
        return dummy.next;
    }

//    Time Complexity : O(max(n, m))
//    Space Complexity : O(max(n, m))
//                      Where :
//                              n -> length of first linked list
//                              m -> length of second linked list
}
