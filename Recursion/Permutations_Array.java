//  GFG Problem : Generate Permutations of an array
//  Link : https://www.geeksforgeeks.org/problems/generate-permutations-of-an-array/1

//  LeetCode Problem : 46. Permutations
//  Link : https://leetcode.com/problems/permutations

import java.util.ArrayList;
import java.util.List;

public class Permutations_Array {
    static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println("Approach 1 : Using an used array :- " + permutationsApproach1(arr));

        System.out.println("Approach 2 : Using swap technique :- " + permutationApproach2(arr));

    }

//    Approach 1 :- Using an array (used array)
    public static List<List<Integer>> permutationsApproach1(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[arr.length];

        solve1 (arr, used, new ArrayList<>(), result);

        return result;
    }

    public static void  solve1 (int[] arr, boolean[] used, List<Integer> current, List<List<Integer>> result ) {
//        Base Case :
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i ++) {
//            If already used :
            if (used[i]){
                continue;
            }
//            Choose :
            current.add(arr[i]);
            used[i] = true;
//            Explore :
            solve1(arr, used, current, result);
//            Undo or backtracking :
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

//    Time Complexity :
//    There are N! permutations to generate and for each permutation we are copying current into the result and that also takes O(N) complexity
//    So, The Overall Time Complexity : O(N × N!)

//    Space Complexity :
//    We're storing all N! permutations, each containing N elements:
//    So, The Overall Space Complexity : O(N × N!)

//    Approach 2 : Swap
    public static List<List<Integer>> permutationApproach2 (int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        solve2(0, arr, result);

        return result;
    }

    public static void solve2 (int index, int[] arr, List<List<Integer>> result) {
//        Base Case :
        if (index == arr.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : arr) {
                current.add(num);
            }
            result.add(current);
            return;
        }

        for (int i = index; i < arr.length; i ++) {
//            Choose :
            swap (arr, index, i);
//            Explore :
            solve2(index + 1, arr, result);
//            Backtracking :
            swap(arr, index, i);
        }
    }

    public static void swap (int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

//    Time Complexity : O(N × N!)
//    Space Complexity : O(N × N!)
}
