//  GFG Problem : Koko Eating Bananas
//  Link : https://www.geeksforgeeks.org/problems/koko-eating-bananas/1

//  LeetCode Problem : 875. Koko Eating Bananas
//  Link : https://leetcode.com/problems/koko-eating-bananas

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Koko Eating Bananas : " + kokoEatingBananas(piles,h));
    }

//    Optimal Approach : Binary Search
    public static int kokoEatingBananas(int[] piles, int h){
        int low = 1;
        int high = 0;

        for (int pile : piles){
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high){
            int mid = low + (high - low) / 2;

            long hours = totalHours(piles, mid);

            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static long totalHours(int[] piles, int speed){
        long hours = 0;

        for (int pile : piles){
            hours += (int)Math.ceil((double) pile / speed);
        }
        return hours;
    }

//    Time Complexity : O(n × log(maxPile))
//      where:
//          n = number of piles
//          maxPile = maximum bananas in a pile

//    Space Complexity : O(1)

}
