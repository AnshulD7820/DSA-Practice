//  GFG Problem : Museum Exhibit Arrangement
//  Link : https://www.geeksforgeeks.org/problems/count-good-numbers/1

//  LeetCode Problem : 1922. Count Good Numbers
//  Link : https://leetcode.com/problems/count-good-numbers

public class Count_Good_Numbers {
    static void main(String[] args) {
        int n = 4;

        System.out.println(countGoodNum(n));
    }

//    Optimal Approach - { Fast Exponentiation }
    private static final long MOD = 1_000_000_007L;

    public static int countGoodNum (long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power (5, evenCount);
        long oddWays = power (4, oddCount);

        return (int) ((evenWays * oddWays) % MOD);
    }

    public static long power (long base, long expo) {
//        Base case
        if (expo == 0) {
            return 1;
        }

//        Solve the smaller problems
        long half = power(base, expo / 2);
//        Square the smaller result
        long result = (half * half) % MOD;
//        If the exponent is odd then multiply by base
        if (expo % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(log n)

}
