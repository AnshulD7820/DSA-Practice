//  GFG Problem : Minimum days to make M bouquets
//  Link : https://www.geeksforgeeks.org/problems/minimum-days-to-make-m-bouquets/1

//  LeetCode Problem : 1482. Minimum Number of Days to Make m Bouquets
//  Link : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets


public class Minimum_Days_To_Make_M_Bouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;

        System.out.println("Minimum Day to Make M Bouquets : " + minDaysMakeMBouquets(bloomDay, m, k));
    }

//   Optimal Binary Search Approach :
    public static int minDaysMakeMBouquets(int[] bloomDay, int m, int k){
        if((long) m * k > bloomDay.length){
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int days : bloomDay){
            low = Math.min(low, days);
            high = Math.max(high, days);
        }

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean canMake(int[] bloomDay, int day,int m, int k){
        int count = 0;
        int bouquets = 0;

        for(int bloom : bloomDay){
            if(bloom <= day){
                count ++;
            }
            else{
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count / k;

        return bouquets >= m;
    }

//    Time Complexity : O(n × log D)
//                                  Where : n = bloomDay.length
//                                          D = maxBloomDay
//    Space Complexity : O(1)
}
