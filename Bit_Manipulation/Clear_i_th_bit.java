//  GFG Problem : Unset Kth Bit
//  Link : https://www.geeksforgeeks.org/problems/replace-the-bit3212/1

public class Clear_i_th_bit {
    static void main(String[] args) {
        int n = 13;
        int i = 2;

        System.out.println("Clear the i-th bit : " + clearIthBit(n, i));

        System.out.println("GFG Problem Solution : " + clearIthBitGFG(n, i));
    }

//    Approach : Using AND (&), Negation (~) and Left Shift (<<) Operator
    public static int clearIthBit (int n, int i) {
        return (n & ~ (1 << i));
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)

//    GFG Approach :
//    The GFG problem uses 1-based indexing and counted from the left side
//    While the previous problem uses 0-based indexing and counted from the right side
//    So for this problem we have to convert the left-based position to the right-based position
//    Code :
    public static int clearIthBitGFG (int n, int i) {
        if (n == 0 || i < 1) {
            return n;
        }

        int totalBits = 32 - Integer.numberOfLeadingZeros(n);

        if (i > n) {
            return n;
        }

        int k = totalBits - i;

        return (n & ~(1 << k));
    }
}
