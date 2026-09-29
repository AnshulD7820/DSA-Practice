//  LeetCode Problem : 131. Palindrome Partitioning
//  Link : https://leetcode.com/problems/palindrome-partitioning

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    static void main(String[] args) {
        String s = "aab";

        System.out.println(palindromePartitioning(s));

    }

//    Optimal Backtracking Approach :
    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> result = new ArrayList<>();

        generate(0, s, new ArrayList<>(), result);

        return result;
    }

    public static void generate (int index, String s, List<String> current, List<List<String>> result ) {
//        Base Case :
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i ++) {
            if (isPalindrome(s, index, i)){
                current.add(s.substring(index, i + 1));

                generate(i + 1, s, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

//    Time Complexity : O(n² × 2ⁿ)
//    Space Complexity : O(n)
}
