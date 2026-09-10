//  GFG Problem : Sort a linked list of 0s, 1s and 2s
//  Link : https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

package Medium_Problem_Of_Linked_List;

public class Sort_Linked_List_0s_1s_2s {
    static void main(String[] args) {
        int[] values = {0, 2, 1, 2, 0, 1};

        Node head = createList(values);

        System.out.print("Brute Force Approach : ");
        printList(sort012Brute(head));

        System.out.print("Optimal Approach : ");
        printList(sort012Optimal(head));
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

//    Function to create linked list
    public static Node createList (int[] values) {
        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i ++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

//    Function to print linked list
    public static void printList (Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//    Brute Force Approach :
    public static Node sort012Brute (Node head) {
        Node temp = head;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        while (temp != null) {
            if (temp.data == 0) {
                count0 ++;
            }
            else if (temp.data == 1){
                count1 ++;
            }
            else {
                count2 ++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0 --;
            }
            else if (count1 > 0) {
                temp.data = 1;
                count1 --;
            }
            else {
                temp.data = 2;
                count2 --;
            }
            temp = temp.next;
        }
        return head;
    }

//    Time Complexity : O(n)   {2 loop approach}
//    Space Complexity : O(1)

//    Optimal Approach :
    public static Node sort012Optimal (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;

        Node temp = head;

        while (temp != null) {
//            When taking a node from original list, we should disconnect it first
            Node next = temp.next;
            temp.next = null;

            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            }
            else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }
            temp = next;
        }

//        Connect 0-list to the 1-list
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
//        Connect 1-list to the 2-list
        one.next = twoDummy.next;

        return zeroDummy.next;
    }

//    Time Complexity : O(n)  { 1 loop approach }
//    Space Complexity : O(1)
}
