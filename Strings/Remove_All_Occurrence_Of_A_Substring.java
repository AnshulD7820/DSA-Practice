//  LeetCode Problem : 1910. Remove All Occurrences of a Substring
//  Link : https://leetcode.com/problems/remove-all-occurrences-of-a-substring

public class Remove_All_Occurrence_Of_A_Substring {
    public static void main(String[] args) {
        String str = "daabcbaabcbc";
        String part = "abc";

        System.out.println("Brute Force Approach : " + removeOccurrence(str, part));
    }

//    This problem belongs to stack, So here we are only doing the brute force approach.

//    Brute Force Approach :
    public static String removeOccurrence(String str, String part){
        while (str.contains(part)){
            int index = str.indexOf(part);

            str = str.substring(0, index) + str.substring(index + part.length());
        }
        return str;
    }

//    Time Complexity : O(n²)
//    Space Complexity ; O(n)
}
