//  GFG Problem : Capacity To Ship Packages Within D Days
//  Link : https://www.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1

//  LeetCode Problem : 1011. Capacity To Ship Packages Within D Days
//  Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

public class Capacity_To_Ship_Packages_Within_D_Days {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;

        System.out.println("Capacity to ship package : "+ shipPackagesWithinDays(weights,days));
    }

//    Optimal Binary Search Approach :
    public static int shipPackagesWithinDays(int[] weights, int days){
        int low = 0;
        int high = 0;

        for (int num : weights){
            low = Math.max(low, num);

            high += num;
        }

        int ans = high;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int requiredDays = daysRequired(weights, mid);

            if(requiredDays <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;

    }

    public static int daysRequired(int[] weights, int capacity){
        int load = 0;
        int days = 1;

        for (int num : weights){
            if(load + num > capacity){
                days ++;
                load = num;
            }
            else{
                load += num;
            }
        }
        return days;
    }

//    Time Complexity : O(n × log S)
//                      Where : n = weights.length
//                              S = sum(weights)
//    Space Complexity : O(1)
}
