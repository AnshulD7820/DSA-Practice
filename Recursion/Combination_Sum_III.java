//  GFG Problem : Unique K-Number Sum
//  Link : https://www.geeksforgeeks.org/problems/combination-sum-iii--111703/1

//  LeetCode Problem : 216. Combination Sum III
//  Link : https://leetcode.com/problems/combination-sum-iii

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    static void main(String[] args) {
        int k = 3;
        int n = 7;

        System.out.println(combinationSumIII(k, n));

    }

//    Optimal Backtracking approach :
    public static List<List<Integer>> combinationSumIII (int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        generate(1, k, n, new ArrayList<>(), result);

        return result;
    }

    public static void generate (int start, int k, int n, List<Integer> current, List<List<Integer>> result) {
//        Base Case :
        if (current.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i ++) {
            if (i > n) {
                break;
            }
//            Pick
            current.add(i);
//            Move to i + 1 because the number can be used only once
            generate(i + 1, k, n - i, current, result);
//            Backtrack
            current.remove(current.size() - 1);
        }
    }

//    Time Complexity : O(2^9 × k)
//    Space Complexity : O(k)
}
