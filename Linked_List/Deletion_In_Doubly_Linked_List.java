//  GFG Problem : Delete Head of Doubly Linked List
//  Link : https://www.geeksforgeeks.org/problems/delete-head-of-doubly-linked-list/1

//  GFG Problem : Delete in a Doubly Linked List
//  Link : https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1

public class Deletion_In_Doubly_Linked_List {
    static void main(String[] args) {
        int[] values = {10, 20, 30, 40};

        int k = 3;

        Node head = createList(values);

        System.out.print("Delete Head of Doubly Linked List : ");
        printList(deleteHead(head));

        head = createList(values);
        System.out.print("Delete Tail of Doubly Linked List : ");
        printList(deleteTail(head));

        head = createList(values);
        System.out.print("Delete Kth Element of Doubly Linked List : ");
        printList(deleteKthEle(head, k));

    }

//    Setup :
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

//    Function to print Doubly Linked List
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    1. Delete Head of Doubly Linked List
    public static Node deleteHead(Node head){
        if (head == null){
            return null;
        }
        head = head.next;

        if (head != null){
            head.prev = null;
        }
        return head;
    }

//    Time Complexity :O(1)
//    Space Complexity :O(1)

//    2. Delete Tail of Doubly Linked List
    public static Node deleteTail(Node head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return null;
        }
        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;

        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    3. Delete Kth Element of Doubly Linked List
    public static Node deleteKthEle(Node head, int k){
        if (head == null || k <= 0){
            return head;
        }

        Node temp = head;

        for (int i = 1; i < k; i ++){
            if (temp == null){
                return head;
            }
            temp = temp.next;
        }
        if (temp == null){
            return head;
        }
//        If deleting the head
        if (temp.prev == null){
            head = temp.next;
            if (head != null){
                head.prev = null;
            }
            return head;
        }
//        Connect previous to next
        if (temp.prev != null){
            temp.prev.next = temp.next;
        }
        if (temp.next != null){
            temp.next.prev = temp.prev;
        }
        return head;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

}
