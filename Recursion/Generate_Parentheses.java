//  GFG Problem : Generate Parentheses
//  Link : https://www.geeksforgeeks.org/problems/generate-all-possible-parentheses/1

//  LeetCode Problem : 22. Generate Parentheses
//  Link : https://leetcode.com/problems/generate-parentheses

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    static void main(String[] args) {
        int n = 3;

        System.out.println(generateParentheses(n));
    }

//    Optimal Approach : { Recursion + Backtracking }
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();

        generate(0, 0, "", n, result);


        return result;
    }

    public static void generate(int open, int close, String current, int n, List<String> result) {
//        Base Case
        if (open == n && close == n){
            result.add(current);
            return;
        }

//        Add an Open Parentheses
        if (open < n) {
            generate(open + 1, close, current + '(', n, result);
        }

//        Add a Close Parentheses
        if (close < open) {
            generate(open, close + 1, current + ')', n, result);
        }
    }

//    Time Complexity : O(n * 2 ^ n)
//    Space Complexity : O(n)
}
