//  GFG Problem : Doubly Linked List from an Array
//  Link : https://www.geeksforgeeks.org/problems/create-a-doubly-linked-list-from-a-given-array/1

public class Doubly_Linked_List {
    static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        Node head = createList(values);

        System.out.print("Arrays to Doubly Linked List : ");
        printList(head);

    }

//    Setup:
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

//    Function to create Doubly Linked List
    public static Node createList(int[] values){
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++){
            Node newNode = new Node(values[i]);

            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }
        return head;
    }

//    Function to print the doubly linked list
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Arrays to Doubly Linked List
    public static Node ArraysToDLL(int[] values){
        if (values.length == 0){
            return null;
        }

        Node head = new Node(values[0]);
        Node prev = head;

        for (int i = 1; i < values.length; i ++){
            Node newNode = new Node(values[i]);

            prev.next = newNode;
            newNode.prev = prev;

            prev = newNode;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n) for the newly created linked list
//    The extra auxiliary space used by the algorithm itself is O(1), excluding the nodes we're creating.

}
