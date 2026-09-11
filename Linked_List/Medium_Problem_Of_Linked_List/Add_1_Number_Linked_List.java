//  GFG Problem : Add 1 to a Linked List Number
//  Link : https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

package Medium_Problem_Of_Linked_List;

public class Add_1_Number_Linked_List {
    static void main(String[] args) {
        int[] values = {9, 9, 9};

        Node head = createList(values);

        System.out.print("Optimal Approach : ");
        printList(add1ToNumberLL(head));
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

//    Optimal Approach : Reverse the Linked List
    public static Node add1ToNumberLL (Node head) {
        if (head == null) {
            return new Node(0);
        }
//        Step 1 : Reverse the Linked List
        head = reverse(head);

//        Step 2 : Add 1
        Node temp = head;
        int carry = 1;

        while (temp != null && carry != 0) {
            int sum = temp.data + carry;

            temp.data = sum % 10;
            carry = sum / 10;

            if (carry != 0 && temp.next == null) {
                temp.next = new Node(0);
            }

            temp = temp.next;
        }
//        Step 3 : Reverse back
        return reverse(head);
    }

    public static Node reverse (Node head) {
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
