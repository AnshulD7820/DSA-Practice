//  LeetCode Problem : 796. Rotate String
//  Link : https://leetcode.com/problems/rotate-string

public class Rotate_String {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println("Brute Force Approach : " + rotateStrBrute(s, goal));
        System.out.println("Optimal Approach : " + rotateStrOptimal(s, goal));
    }

//    Brute Force Approach :
    public static boolean rotateStrBrute(String s, String goal){
        if (s.length() != goal.length()){
            return false;
        }

        String current = s;

        for (int i = 0; i < s.length(); i ++){
            if (current.equals(goal)){
                return true;
            }

            current = current.substring(1) + current.charAt(0);
        }
        return false;
    }

//    Each rotation creates a string of length n and there are total n rotations
//    Time Complexity : O(n²)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static boolean rotateStrOptimal(String s, String goal){
        if (s.length() != goal.length()){
            return false;
        }

        String doubled = s + s;

        return doubled.contains(goal);
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)
}
