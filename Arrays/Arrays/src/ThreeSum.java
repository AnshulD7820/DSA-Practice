import java.util.*;

// LeetCode Problem : 15. 3Sum
// Link : https://leetcode.com/problems/3sum


public class ThreeSum {
    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};

        System.out.println("Brute Force Approach : " + threeSumBrute(arr));
        System.out.println("Better Approach : " + threeSumBetter(arr));
        System.out.println("Optimal Approach : " + threeSumOptimal(arr));

    }

//    Brute Force Approach :
    static List<List<Integer>> threeSumBrute(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j ++){
                for (int k = j + 1; k < n; k ++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);

                        Collections.sort(temp);

                        if(!result.contains(temp)){
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }
//    Time Complexity : O(n⁵) (worst case due to contains)
//                      It’s often closer to O(n³) if few valid triplets exist.
//    Space Complexity : O(number of triplets) ||  O(n²)

//    Better Approach :
    static List<List<Integer>> threeSumBetter(int[] arr){
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++){
                int third = -(arr[i] + arr[j]);
                if(seen.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j] , third);
                    Collections.sort(temp);
                    set.add(temp);
                }
            seen.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }
//    Time Complexity : O(n²)
//    Space Complexity : O(n)

//    Optimal Approach :
    static List<List<Integer>> threeSumOptimal(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            if(i > 0 && arr[i] == arr[i - 1])                   // Skip Duplicates
                continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0){
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
//                    Skip Duplicates:
                    while (left < right && arr[left] == arr[left + 1])
                        left ++;
                    while (left < right && arr[right] == arr[right - 1])
                        right --;
                    left ++;
                    right --;
                }
                else if(sum < 0){
                    left ++;
                }
                else{
                    right --;
                }
            }
        }
        return result;
    }
//    Time Complexity : O(n log n + n²) = O(n²)
//    Space Complexity : O(1)  ....excluding result

}
