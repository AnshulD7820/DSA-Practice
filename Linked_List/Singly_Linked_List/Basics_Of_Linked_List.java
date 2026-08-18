package Singly_Linked_List;
//  GFG Problem : Array to Linked List
//  Link : https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1

//  GFG Problem : LinkedList Traversal
//  Link : https://www.geeksforgeeks.org/problems/linkedlist-traversal/1

//  GFG Problem : Length of Linked List
//  Link : https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1

//  GFG Problem : Search in Linked List
//  Link : https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1

public class Basics_Of_Linked_List {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        int target = 20;

        System.out.print("Array to Linked List : ");
        Node head = convertArrToLL(arr);
        printLL(head);

        System.out.print("Traverse In Linked List : ");
        traverseInLL(head);

        System.out.println();
        System.out.println("Length of Linked List : " + lengthOfLL(head));

        System.out.println("Search an Element In Linked List : " + searchElemInLL(head, target));

    }

//      Node class in Java :
    static  class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//    To print the Linked List
    public static void printLL(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp= temp.next;
        }
        System.out.println("null");
    }

//    Converting an Array into Linked List
    public static Node convertArrToLL(int[] arr){
        if (arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);

        Node temp = head;

        for (int i = 1; i < arr.length; i ++){
            temp.next = new Node(arr[i]);

            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)

//    Traversal in Linked List
    public static void traverseInLL(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

//    Time Complexity : O(n)

//    Find the Length of Linked List
    public static int lengthOfLL(Node head){
        int count = 0;
        Node temp = head;

        while (temp != null){
            count ++;

            temp = temp.next;
        }
        return count;
    }

//    Time Complexity : O(n)

//    Search an Element in Linked List
    public static boolean searchElemInLL(Node head, int target){
        Node temp = head;

        while (temp != null){
            if(temp.data == target){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

//    Time Complexity : O(n)

}
