//  GFG Problem : Possible Words From Phone Digits
//  Link : https://www.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1

//  LeetCode Problem : 17. Letter Combinations of a Phone Number
//  Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Phone_Number {
    static void main(String[] args) {
        String digits = "881";

        System.out.println(letterCombinationPhoneNum(digits));
    }

//    Optimal Backtracking Approach :
    public static List<String> letterCombinationPhoneNum (String digits) {
        List<String> result = new ArrayList<>();

        String[] mapping = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        generate(0, digits, mapping, new StringBuilder(), result);

        return result;

    }

    public static void generate (int index, String digits, String[] mapping, StringBuilder current, List<String> result) {
//        Base Case :
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
//        Get letters corresponding to that digit
        String letter = mapping[digits.charAt(index) - '0'];
//        Skip digits 0 and 1
        if (letter.length() == 0) {
            generate(index + 1, digits, mapping, current, result);
            return;
        }
//        Try every possible letter
        for (char ch : letter.toCharArray()) {
//            Choose :
            current.append(ch);
//            Explore more digits
            generate(index + 1, digits, mapping, current, result);
//            Undo or backtracking
            current.deleteCharAt(current.length() - 1);
        }
    }

//    Time Complexity :
//    Let n = number of digits
//        C = number of generated combination
//    We have to produce all C strings, each of length n
//    So the output construction itself requires : O(C × n) time
//    The recursion depth is : O(n)
//    and the StringBuilder uses : O(n)
//    Therefore the overall time complexity becomes :
//                                                      O(n × 4ⁿ)
//    Space Compelxity : O(n) { auxiliary }
}
