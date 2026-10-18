public class Toggle_i_th_bit {
    static void main(String[] args) {
        int n = 13;
        int i = 2;

        System.out.println("Toggle the i-th bit : " + toggleIthBit(n, i));
    }

//    Approach : Use the XOR (^) Operator :
    public static int toggleIthBit (int n , int i) {
        return n ^ (1 << i);
    }

//    Time Complexity : O(1)
//    Space Complexity : O(1)
}
