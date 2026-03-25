import java.util.Arrays;
import java.util.HashSet;

// LeetCode Problem : 128. Longest Consecutive Sequence
// Link : https://leetcode.com/problems/longest-consecutive-sequence

// GFG Problem : Longest Consecutive Subsequence
// Link : https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};

        System.out.println("Brute Force Approach : " + longestConsecutiveSequenceBrute(arr));
        System.out.println("Better Approach : " + longestConsecutiveSequenceBetter(arr));
        System.out.println("Optimal Approach : " + longestConsecutiveSequenceOptimal(arr));
    }

//     Brute Force Approach :
    static int longestConsecutiveSequenceBrute(int[] arr){
        int n = arr.length;
        int longest = 0;

        for (int i = 0; i < n; i ++){
            int current = arr[i];
            int count = 1;
            boolean found = true;
            while (found){
                found = false;
                for (int j = 0; j < n; j ++){
                    if (arr[j] == current + 1){
                        current ++;
                        count ++;
                        found = true;
                        break;
                    }
                }
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
//     Time Complexity : O(N * N)
//     Space Complexity : O(1)

//    Better Approach :
    static int longestConsecutiveSequenceBetter(int[] arr){
        int n = arr.length;

        if(n == 0) return 0;

        Arrays.sort(arr);

        int longest = 1;
        int count = 1;
        for (int i = 1; i < n; i ++){
            if(arr[i] == arr[i-1] + 1){   // This line of code means : Is the current element exactly one greater than
                                         //                             the previous element?
                count ++;
            } else if (arr[i] != arr[i - 1]) {
                count = 1;
            }
        longest = Math.max(longest, count);
        }
        return longest;
    }
//    Time Complexity : O(N Log N)
//    Space Complexity : O(1)

//  Optimal Approach :
    static int longestConsecutiveSequenceOptimal(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set){
            if(!set.contains(num - 1)){
                int current = num;
                int count = 1;

                while (set.contains(current + 1)){
                    current ++;
                    count ++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
//    Time Complexity : O(N)
//    Space Complexity : O(N)
}
