//  GFG Problem : All Subsequences of String
//  Link : https://www.geeksforgeeks.org/problems/power-set4302/1

//  LeetCode Problem : 78. Subsets
//  Link : https://leetcode.com/problems/subsets

import java.util.ArrayList;
import java.util.Collections;

public class Power_Set {
    static void main(String[] args) {
        String str = "abc";

        System.out.println(powerSet(str));
    }

//    Recursive Approach :
    public static ArrayList<String> powerSet (String str) {
        ArrayList<String> result = new ArrayList<>();

        generate(0, str, "", result);
        Collections.sort(result);    // In Case the problem says to return in lexicographical order
        return result;
    }

    public static void generate(int index, String str, String current, ArrayList<String> result) {
//        Base Case :
        if (index == str.length()){
            result.add(current);
            return;
        }

//        Include
        generate(index + 1, str, current + str.charAt(index), result);

//        Exclude
        generate(index + 1, str, current, result);
    }

//    Time Complexity : O(n·2ⁿ)
//    Space Complexity : O(n·2ⁿ)
}
