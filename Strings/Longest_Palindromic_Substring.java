//  GFG Problem : Longest Palindromic Substring
//  Link : https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1

//  LeetCode Problem : 5. Longest Palindromic Substring
//  Link : https://leetcode.com/problems/longest-palindromic-substring

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "babad";

        System.out.println("Brute Force Approach : " + longestPalindromicSubstringBrute(s));
        System.out.println("Optimal Approach : " + longestPalindromicSubstringOptimal(s));
    }

//    Brute Force Approach :
    public static String longestPalindromicSubstringBrute(String s){
        String ans = "";

        for (int i = 0; i < s.length(); i ++){
            for (int j = i; j < s.length(); j ++){
                String sub = s.substring(i , j + 1);

                if(isPalindromic(sub) && sub.length() > ans.length()){
                    ans = sub;
                }
            }
        }
        return ans;
    }
    public static boolean isPalindromic(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

//    Total Substring -> O(n²)
//    Checking Palindrome -> O(n)
//    So Overall :
//                Time Complexity : O(n³)
//    Space Complexity : O(1)

//    Optimal Approach : (Expand Around Center)
    public static String longestPalindromicSubstringOptimal(String s){
        if (s.length() <= 1){
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i ++){
//            Odd length palindrome (center at i)
            int len1 = expandFromCenter(s, i, i);
//            Even length palindrome (center between i and i + 1)
            int len2 = expandFromCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

//            Update longest palindrome
            if (maxLen > end - start + 1){
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
//        Length of the palindrome
        return right - left - 1;
    }

//    Time Complexity : O(n²)
//    Space Complexity : O(1)
}
