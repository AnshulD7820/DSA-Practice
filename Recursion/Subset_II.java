//  GFG Problem : Distinct Subsets
//  Link : https://www.geeksforgeeks.org/problems/subset-sum-ii/1

//  LeetCode Problem : 90. Subsets II
//  Link : https://leetcode.com/problems/subsets-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
    static void main(String[] args) {
        int[] arr = {1, 2, 2};

        System.out.println(subsetII(arr));

    }

//    Optimal Recursive Approach :
    public static List<List<Integer>> subsetII (int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        generate(0, arr, new ArrayList<>(), result);

        return result;
    }

    public static void generate (int index, int[] arr, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < arr.length; i ++) {
            if (i > index && arr[i] == arr[i - 1]){
                continue;
            }
            current.add(arr[i]);
            generate(i + 1, arr, current, result);
            current.remove(current.size() - 1);
        }
    }

//    Time Complexity : O(2ⁿ . n) + O(n log(n))
//    Space Complexity : O(n)
}
