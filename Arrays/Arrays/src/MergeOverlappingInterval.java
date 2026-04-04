import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  LeetCode Problem : 56. Merge Intervals
//  Link : https://leetcode.com/problems/merge-intervals

//  GFG Problem : Overlapping Intervals
//  Link : https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1

public class MergeOverlappingInterval {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println("Brute Force Approach : " + Arrays.deepToString(mergeOverlappingIntervalBrute(arr)));
        System.out.println("Optimal Approach : " + Arrays.deepToString(mergeOverlappingIntervalOptimal(arr)));
    }

//    Brute Force Approach :
    static int[][] mergeOverlappingIntervalBrute(int[][] arr){
        int n = arr.length;
//        Arrays.sort(arr, (a,b) -> a[0] - b[0]);       // In rare case , Integer overflow can occur
//        Safer Version to sort the 2D array:
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        boolean[] merged = new boolean[n];
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n; i ++){
            if(merged[i])
                continue;
            int start = arr[i][0];
            int end = arr[i][1];
            for (int j = i + 1; j < n; j ++){
                if (!merged[j] && arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                    merged[j] = true;
                }
            }
            res.add(new int[]{start,end});
        }
        return res.toArray(new int[0][]);
    }
//    Time Complexity : O(n log n + n²)
//    Space Complexity : O(n)

//    Optimal Approach :
    static int[][] mergeOverlappingIntervalOptimal(int[][] arr){
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int n = arr.length;

        int[] cur = arr[0];

        for (int i = 1 ; i < n; i ++){
            int[] next = arr[i];

            if(next[0] <= cur[1]){
                cur[1] = Math.max(cur[1], next[1]);
            }
            else{
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }
//    Time Complexity : O(n log n)
//    Space Complexity : O(n)
}

//  In this problem, Sorting works because overlapping intervals will come next to each other
//  Why Sort ?
//  --> To ensure overlapping intervals come together for linear merging
