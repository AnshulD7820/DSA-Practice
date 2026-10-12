//  GFG Problem : Swap Two Numbers
//  Link : https://www.geeksforgeeks.org/problems/swap-the-numbers/1

import java.util.Arrays;

public class Swap_Two_Numbers_XOR {
    static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Swap Two Numbers : " + Arrays.toString(swapTwoNum(a, b)));
    }

//    Approach :
    public static int[] swapTwoNum (int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        return new int[] {a, b};
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)
}
