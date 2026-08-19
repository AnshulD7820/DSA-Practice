package Medium_Problem_Of_Linked_List;

//  GFG Problem : Middle of a Linked List
//  Link : https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1

//  LeetCode Problem : 876. Middle of the Linked List
//  Link : https://leetcode.com/problems/middle-of-the-linked-list

public class Middle_Element_Linked_List {
    static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(middleElemBrute(head));

        head = createList(values);
        System.out.print("Optimal Approach : ");
        printList(middleElemOptimal(head));

    }

//    Setup :
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

//    Function to create a linked list
    public static Node createList(int[] values){
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++){
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Function to print a linked list
    public static void printList(Node head){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Brute Force Approach :
    public static Node middleElemBrute(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node temp = head;
        int count = 0;

        while (temp != null){
            count ++;
            temp = temp.next;
        }

        int mid = count / 2 + 1;
        temp = head;

        while (temp != null){
            mid = mid - 1;

            if (mid == 0){
                break;
            }

            temp = temp.next;
        }
        return temp;
    }

//    Time Complexity : O(n + n / 2) ~ O(n)
//    Space Complexity : O(1)

//    Optimal Approach : Tortoise and Hare Method
    public static Node middleElemOptimal(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

//    Time Complexity : O(n / 2) ~ O(n)
//    Space Complexity : O(1)
}
