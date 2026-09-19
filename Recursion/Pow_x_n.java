//  GFG Problem : Implement Pow
//  Link : https://www.geeksforgeeks.org/problems/powx-n/1

//  LeetCode Problem : 50. Pow(x, n)
//  Link : https://leetcode.com/problems/powx-n

public class Pow_x_n {
    static void main(String[] args) {
        double x = 2.00000;
        int n = -2;

        System.out.println("Iterative Approach : " + powIterative(x, n));
        System.out.println("Recursive Approach : " + powRecursive(x, n));
    }

//    Iterative Approach : { This approach is considered as optimal approach because it avoids recursive stack space }
    public static double powIterative (double x, int n) {
        long N = n;

//        If the N is negative, then :
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double res = 1.0;
//        When the power of x is positive
        while (N > 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(1)

//    Recursive Approach :
    public static double powRecursive (double x, int n) {
        long N = n;

//        If the power is negative
        if (N <  0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    public static double power(double x, long n) {
//        Base Case :
        if (n == 0) {
            return 1.0;
        }
//        Solve the smaller problem
        double half = power(x, n / 2);
//        Combine the result
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(log n)
}
