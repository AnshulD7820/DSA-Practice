import java.util.ArrayList;
import java.util.*;

// LeetCode Problem : 1299. Replace Elements with Greatest Elements on Right Side
// Link : https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

// GFG Problem : Array Leaders
// Link : https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};

        System.out.println("Brute Force Approach : " + leadersInArrayBrute(arr));
        System.out.println("Optimal Approach : " + leadersInArrayOptimal(arr));

        System.out.println("LeetCode Solution : " + Arrays.toString(leadersInArrayLeetCode(arr)));
    }

//     Brute Force Approach :
    static ArrayList<Integer> leadersInArrayBrute(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            boolean isLeader = true;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] > arr[i]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader)
                result.add(arr[i]);
        }

        return result;
    }
//     Time Complexity : O(N * N)
//     Space Complexity : O(1) {We are using the extra space to print the answer which will take O(N) space complexity}

    // Optimal Approach :
    static ArrayList<Integer> leadersInArrayOptimal(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        int maxFromRight = arr[arr.length - 1];
        result.add(maxFromRight);  // Because the rightmost element will always be the leader


        for (int i = arr.length - 2 ; i >=0 ; i --){
            if (arr[i] >= maxFromRight){
                result.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        Collections.reverse(result);
//      Collections.sort(result);
        return result;
    }
//  Time Complexity : O(N)
//  Space Complexity : O(1) {We are using the extra space to print the answer which will take O(N) space complexity}

//  -> the space complexity can further be increased if the problem state that to return the result in sorted order,
//     in this case then we have to sort the answer which will take the space complexity of O( N log N )

//  -> Since we are doing here back traversal, the result will be stored in reversal order, we can modify the answer
//     as per the problem requirement.

//  LeetCode Problem Solution :
    static int[] leadersInArrayLeetCode(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            result.add(max);
            max = Math.max(max,temp);
        }
        Collections.reverse(result);

        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result){
            res[i++] = num;
        }
        return res;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}


