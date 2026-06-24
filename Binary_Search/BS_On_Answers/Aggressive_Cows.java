import java.util.Arrays;

//  GFG Problem : Aggressive Cows
//  Link : https://www.geeksforgeeks.org/problems/aggressive-cows/1

//  LeetCode Problem : 1552. Magnetic Force Between Two Balls
//  Link : https://leetcode.com/problems/magnetic-force-between-two-balls

public class Aggressive_Cows {
    public static void main(String[] args) {
        int[] stalls = {1,2,3,4,7};
        int cows = 3;

        System.out.println("Brute Force Approach : " + aggressiveCowsBrute(stalls, cows));
        System.out.println("Optimal Approach : " + aggressiveCowsOptimal(stalls, cows));
    }
//    Brute Force Approach :
    public static int aggressiveCowsBrute(int[] stalls, int cows){
        Arrays.sort(stalls);

        int maxDist = stalls[stalls.length - 1] - stalls[0];

        int ans = 0;

        for (int i = 1; i <= maxDist ; i ++){
            if(canPlace(stalls, cows, i)){
                ans = i;
            }
        }
        return ans;
    }
    public static boolean canPlace(int[] stalls, int cows, int d){
        int count = 1;
        int last = stalls[0];

        for(int i = 1 ; i < stalls.length ; i ++){
            if(stalls[i] - last >= d){
                count ++;
                last = stalls[i];
            }
        }
        return count >= cows;
    }

//    Time Complexity : O(NlogN) + O(N *(max(stalls[])-min(stalls[])))
//                          Where : NlogN - sorting the array
//                                  N *(max(stalls[])-min(stalls[])) - Linear search
//    Space Complexity : O(1)

//    Optimal Approach :
    public static int aggressiveCowsOptimal(int[] stalls, int cows){
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canPlace(stalls, cows,mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
//                          Where : NlogN - sorting the array
//                                  N - helper function through which we find canPlace
//                                  log(max(stalls[])-min(stalls[]) - binary search
//    Space Complexity : O(1)
}
