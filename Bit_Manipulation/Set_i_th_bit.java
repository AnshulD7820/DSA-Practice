//  GFG Problem : Set kth Bit
//  Link : https://www.geeksforgeeks.org/problems/set-kth-bit3724/1

public class Set_i_th_bit {
    static void main(String[] args) {
        int n = 9;
        int i = 2;

        System.out.println("Set the i-th bit : "+ setIthBit(n, i));
    }

//    Approach :
    public static int setIthBit (int n, int i) {
        return (n | (1 << i));
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)
}
