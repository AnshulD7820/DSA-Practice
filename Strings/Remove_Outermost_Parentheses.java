//  GFG Problem : Outermost Parentheses of Primitives
//  Link : https://www.geeksforgeeks.org/problems/outermost-parentheses/1

//  LeetCode Problem : 1021. Remove Outermost Parentheses
//  Link : https://leetcode.com/problems/remove-outermost-parentheses

public class Remove_Outermost_Parentheses {
    public static void main(String[] args) {
        String str = "(()())(())";

        System.out.println("Brute Force Approach : " + removeParenthesesBrute(str));
        System.out.println("Optimal Approach : " + removeParenthesesOptimal(str));

    }

//    Brute Force Approach :
    public static String removeParenthesesBrute(String str){
        StringBuilder ans = new StringBuilder();

        int counter = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == '('){
                counter ++;
            }
            else{
                counter --;
            }
            if (counter == 0){
                ans.append(str.substring(start + 1, i ));
                start = i + 1;
            }
        }
        return ans.toString();
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static String removeParenthesesOptimal(String str){
        StringBuilder ans = new StringBuilder();

        int counter = 0;

        for (char ch : str.toCharArray()){
            if(ch == '('){
                if(counter > 0){
                    ans.append(ch);
                }
                counter ++;
            }
            else{
                counter --;
                if (counter > 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)
}
