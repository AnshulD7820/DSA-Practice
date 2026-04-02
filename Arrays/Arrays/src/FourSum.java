import java.util.*;

// LeetCode Problem : 18. 4Sum
// Link : https://leetcode.com/problems/4sum

// GFG Problem : 4 Sum - All Quadruples
// Link : https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println("Brute Force Approach : " + fourSumBrute(arr,target));
        System.out.println("Better Approach : " + fourSumBetter(arr,target));
        System.out.println("Optimal Approach : " + fourSumOptimal(arr,target));
    }

//    Brute Force Approach :
    static List<List<Integer>> fourSumBrute(int[] arr, int target){
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                for (int k = j + 1; k < n; k ++){
                    for (int l = k + 1; l < n; l ++){
                        if((long) arr[i] + arr[j] + arr[k] + arr[l] == target){
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
//    Time Complexity : O(n⁴)   —-> four nested loops
//    Space Complexity : O(quads)   --> HashSet

//    Better Approach :
    static List<List<Integer>> fourSumBetter(int[] arr, int target){
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                HashSet<Integer> seen = new HashSet<>();
                for (int k = j + 1; k < n; k ++){
                    int fourth = target - (arr[i] + arr[j] + arr[k]);
                    if (seen.contains(fourth)){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
//    Time Complexity : O(n³)
//    Space Complexity : O(n)

//    Optimal Approach :
    static List<List<Integer>> fourSumOptimal(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0 ; i < n ; i ++){
//            Skip Duplicate i
            if(i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n ; j ++){
//                Skip Duplicate j
                if(j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right){
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target){
                        result.add(Arrays.asList(arr[i],arr[j], arr[left], arr[right]));
//                        Skip Duplicate left and right
                        while (left < right && arr[left] == arr[left + 1])
                            left ++;
                        while (left < right && arr[right] == arr[right - 1])
                            right --;

                        left ++;
                        right --;
                    }
                    else if( sum < target){
                        left ++;
                    }
                    else{
                        right --;
                    }
                }
            }
        }
        return result;
    }
//    Time Complexity :  O(n³)
//    Space Complexity : O(1)
}
