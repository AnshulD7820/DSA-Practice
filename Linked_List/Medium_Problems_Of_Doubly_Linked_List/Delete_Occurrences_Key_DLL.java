//  GFG Problem : Delete All Occurrences in DLL
//  Link : https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1

package Medium_Problems_Of_Doubly_Linked_List;

public class Delete_Occurrences_Key_DLL {
    static void main(String[] args) {
        int[] values = {1, 2, 4, 2, 5, 2};
        int key = 2;;

        Node head = createList(values);

        printList(deleteAllOccurrences(head, key));
    }

//    Setup :
    static class Node {
        int data;
        Node prev;
        Node next;

        Node (int data) {
            this.data = data;
            this.prev = null;;
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

//    Function to Print the Doubly Linked List
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Optimal Approach :
    public static Node deleteAllOccurrences (Node head, int key) {
//        Removing matching nodes from the beginning
        while (head != null && head.data == key) {
            head = head.next;
        }
//        Empty list
        if (head == null) {
            return null;
        }
//        New head has no previous node
        head.prev = null;

        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                temp.prev.next = temp.next;

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
