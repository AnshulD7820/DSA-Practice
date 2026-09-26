//  GFG Problem : Target Sum Combinations
//  Link : https://www.geeksforgeeks.org/problems/combination-sum-1587115620/1

//  LeetCode Problem : 39. Combination Sum
//  Link : https://leetcode.com/problems/combination-sum

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    static void main(String[] args) {
        int[] candidates = {2, 3, 5, 4};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

//    Optimal Approach : Recursive Include / Exclude
    public static List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        generate(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    public static void generate (int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
//        Base Case :
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

//        Include :
        if (candidates[index] <= target) {
            current.add(candidates[index]);
            generate(index, candidates, target - candidates[index], current, result);
            current.remove(current.size() - 1);
        }

//        Exclude :
        generate(index + 1, candidates, target, current, result);
    }

//    Complexity :
//    The exact number of recursive calls depends on the candidates and target
//    A useful interview-level description is:
//
//    Time: exponential in the worst case, because we explore many combinations.
//    Auxiliary recursion space: O(target / minCandidate) in the deepest path, excluding the output.
//    Output space: depends on the number and size of valid combinations.
//
//    For example, if the smallest candidate is 1, a recursion path could contain up to target elements.
}
