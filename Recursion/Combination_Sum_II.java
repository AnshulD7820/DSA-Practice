// GFG Problem : Combination Sum Without Repetition
//  Link : https://www.geeksforgeeks.org/problems/combination-sum-ii-1664263832/1

//  LeetCode Problem : 40. Combination Sum II
//  Link : https://leetcode.com/problems/combination-sum-ii

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(combinationSumII(candidates, target));
    }

//    Recursive Approach :
    public static List<List<Integer>> combinationSumII (int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        generate(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    public static void generate (int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
//       Target Reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i ++) {
//            Skip duplicate value at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
//            Since array is sorted, no later element can work
            if (candidates[i] > target) {
                break;
            }
//            Pick
            current.add(candidates[i]);
//            Move to i + 1 because each element can be used once
            generate(i + 1, candidates, target - candidates[i], current, result);
//            Backtrack
            current.remove(current.size() - 1);
        }
    }

//    Complexity :
//      There can still be exponentially many combinations in the worst case.
//      So interview-level complexity is generally described as:
//          Time Complexity : Exponential in the worst case, with additional cost for sorting:
//                              O(n log n)
//                              for sorting, plus the backtracking search.
//          Auxiliary recursion space:
//                                      O(n)
//                                      for recursion depth, excluding the output.
//
//          Output space: Can itself be exponential because we may have many valid combinations.
//
//    The exact search complexity depends heavily on the candidate values and target.
}
