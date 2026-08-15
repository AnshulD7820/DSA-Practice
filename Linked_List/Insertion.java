//  GFG Problem : Linked List Insertion At Beginning
//  Link : https://www.geeksforgeeks.org/problems/linked-list-insertion-at-beginning/1

//  GFG Problem : Linked List End Insertion
//  Link : https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/1

//  GFG Problem : Insert in a Singly Linked List
//  Link : https://www.geeksforgeeks.org/problems/insertion-at-a-given-position-in-a-linked-list/1


public class Insertion {
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        int val = 5;

        int k = 3;

        int X = 30;

        Node head = createList(values);

        System.out.print("Insertion At The Head : ");
        printList(insertAtHead(head, val));

        head = createList(values);
        System.out.print("Insertion At The Tail : ");
        printList(insertAtTail(head, val));

        head = createList(values);
        System.out.print("Insertion At The Kth Position : ");
        printList(insertAtKthPos(head, k, val));

        head = createList(values);
        System.out.print("Insertion Before Value X : ");
        printList(insertBeforeValX(head, X, val));

    }

//    Setup :
    static  class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//    Helper Function To Create Linked List
    public static Node createList(int[] values){
        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i ++){
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

//    Function to print the Linked List
    public static void printList(Node head){
        Node current = head;

        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

//    1. Insertion at the head
    public static Node insertAtHead(Node head, int val){
        Node newNode = new Node(val);

        newNode.next = head;

        return newNode;
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)

//    2. Insertion at the tail
    public static Node insertAtTail(Node head, int val){
        Node newNode = new Node(val);

        if (head == null){
            return newNode;
        }

        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    3. Insertion at the kth position
    public static Node insertAtKthPos(Node head, int k, int val){
        if (k <= 0){
            return head;
        }
//        Insert at the head
        if (k == 1){
            Node newNode = new Node(val);
            newNode.next = head;
            return head;
        }

        Node temp = head;

//        Reach (k - 1)th node
        for (int i = 1; i < k - 1; i ++){
            if (temp == null){
                return head;
            }
            temp = temp.next;
        }

        if (temp == null){
            return head;
        }

        Node newNode = new Node(val);

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    4. Insertion Before value X
    public static Node insertBeforeValX(Node head, int X, int val){
        if (head == null){
            return null;
        }

//        X is at the head
        if (head.data == 1){
            Node newNode = new Node(val);

            newNode.next = head;

            return head;
        }
        Node temp = head;

        while (temp.next != null){
            if (temp.next.data == X){
                Node newNode = new Node(val);

                newNode.next = temp.next;
                temp.next = newNode;

                return head;
            }
            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

}
