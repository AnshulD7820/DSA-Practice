//  GFG Problem : Subset Sums
//  Link : https://www.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset_Sum {
    static void main(String[] args) {
        int[] arr = {2, 3};

        System.out.println(subsetSum(arr));
    }

//    Optimal Recursive Approach :
    public static List<Integer> subsetSum (int[] arr) {
        List<Integer> result = new ArrayList<>();

        generate(0, 0, arr, result);

        Collections.sort(result);     // If the problem says to return in lexicographical order

        return result;
    }

    public static void generate (int index, int sum, int[] arr, List<Integer> result) {
//        Base Case :
        if (index == arr.length) {
            result.add(sum);
            return;
        }

//        Include :
        generate(index + 1, sum + arr[index], arr, result);

//        Exclude :
        generate(index + 1, sum, arr, result);
    }

//    Time Complexity : O(2ⁿ) + O(2ⁿ log(2ⁿ))
//    Space Complexity : O(2ⁿ)
}
