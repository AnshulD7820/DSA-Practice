//  GFG Problem : Anagram
//  Link : https://www.geeksforgeeks.org/problems/anagram-1587115620/1

//  LeetCode Problem : 242. Valid Anagram
//  Link : https://leetcode.com/problems/valid-anagram

import java.util.Arrays;

public class Check_Two_Strings_Are_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Brute Force Approach : " + checkAnagramBrute(s, t));
        System.out.println("Optimal Approach : " + checkAnagramOptimal(s, t));
    }

//    Brute Force Approach : USING SORTING METHOD
    public static boolean checkAnagramBrute(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < s.length(); i ++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

//    Time Complexity : O(n log n)
//    Space Complexity : O(n)

//    Optimal Approach : USING FREQUENCY ARRAY
    public static boolean checkAnagramOptimal(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i ++){
            freq[s.charAt(i) - 'a'] ++;
            freq[t.charAt(i) - 'a'] --;
        }

        for (int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
