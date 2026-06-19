//  GFG Problem : Find nth root of m
//  Link : https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1

public class Nth_Root_Of_Number {
    public static void main(String[] args) {
        int n = 3;
        int m = 27;

        System.out.println("Brute Force Approach : " + nthRootOfNumberBrute(n, m));

        System.out.println("Optimal Approach : " +nthRootOfNumberOptimal(n, m));
    }

//    Brute Force Approach:
    public static int nthRootOfNumberBrute(int n, int m){
        for (int i = 1; i <= m; i ++){
            long value = 1;
            for (int j = 1; j <= n; j ++){
                value *= i;
            }
            if(value == m){
                return i;
            }
            if(value > m){
                break;
            }
        }
        return -1;
    }

//    Time Complexity : O(m × n)
//    Space Complexity : O(1)

//    Optimal Approach : Binary Search
    public static int nthRootOfNumberOptimal(int n, int m){
        int low = 1;
        int high = m;

        while (low <= high){
            int mid = low + (high - low) / 2;

            long ans = 1;

            for (int i = 1; i <= n ; i ++){
                ans *= mid;

                if(ans > m)
                    break;
            }

            if(ans == m){
                return mid;
            }
            if(ans < m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

//    Time Complexity : O(n * log m)
//    Space Complexity : O(1)
}
