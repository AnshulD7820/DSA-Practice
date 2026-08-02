//  GFG Problem : Maximum Nesting Depth of the Parentheses
//  Link : https://www.geeksforgeeks.org/problems/maximum-nesting-depth-of-the-parentheses/1

//  LeetCode Problem : 1614. Maximum Nesting Depth of the Parentheses
//  Link : https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses

public class Maximum_Nesting_Depth_Parantheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println("Optimal Approach : " + maxDepth(s));
    }

//    Optimal Approach : "COUNTER"
    public static int maxDepth(String s){
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()){
            if(ch == '('){
                depth ++;
            }
            if (ch == ')'){
                depth --;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
