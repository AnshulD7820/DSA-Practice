//  GFG Problem : Remove duplicates from a sorted DLL
//  Link : https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1

package Medium_Problems_Of_Doubly_Linked_List;

public class Remove_Duplicates_Sorted_DLL {
    static void main(String[] args) {
        int[] values = {1, 1, 2, 3, 4, 5, 6, 6};

        Node head = createList(values);

        printList(removeDuplicates(head));
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

//    Optimal Approach :
    public static Node removeDuplicates (Node head) {
        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;

            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
