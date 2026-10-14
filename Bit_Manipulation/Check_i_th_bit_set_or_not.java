//  GFG Problem : Check K-th Bit
//  Link : https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1

public class Check_i_th_bit_set_or_not {
    static void main(String[] args) {
        int n = 13;
        int i = 2;

        System.out.println("Using Left Shift : " + checkIthBitApp1(n, i));
        System.out.println("Using Right Shift : " + checkIthBitApp2(n, i));
    }

//    Approach 1 : Using Left Shift ( << )
    public static boolean checkIthBitApp1 (int n, int i) {
        if ((n & (1 << i))!= 0) {
            return true;
        }
        else {
            return  false;
        }
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)


//    Approach 2 : Using Right Shift ( >> )
    public static boolean checkIthBitApp2 (int n , int i) {
        if (((n >> i) & 1) != 0) {
            return true;
        }
        else {
            return false;
        }
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)
}
