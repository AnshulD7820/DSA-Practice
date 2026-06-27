//  GFG Problem : Minimize Max Distance to Gas Station
//  Link : https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1

//  LeetCode problem is locked : only access to the premium users

public class Minimise_Maximum_Distance_Between_Gas_Stations {
    public static void main(String[] args) {

        int[] stations = {3, 6, 12, 19, 33};
        int k = 3;

        System.out.println("Minimise Maximum Distance Between Gas Stations : " + minimiseMaxDistance(stations, k));
    }

//    Brute Force Approach :
//    - Try Every Position for new stations
//    - This becomes very complicated and ends up throwing time limit exceed
//    - And also this approach is not even practically possible

//    Optimal Approach : Binary Search
    public static double minimiseMaxDistance(int[] stations, int k){
        double low = 0;
        double high = 0;

        for (int i = 1; i < stations.length; i ++){
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        double diff = 1e-6;

        while (high - low > diff){
            double mid = low + (high - low) / 2.0;

            int required = numberOfGasStationsRequired(stations, mid);

            if(required > k){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return high;
    }

    public static int numberOfGasStationsRequired(int[] stations, double dist){
        int count = 0;

        for (int i = 1; i < stations.length; i ++){
            double gap = stations[i] - stations[i - 1];

            int needed = (int)(gap / dist);

            if(gap == needed * dist){
                needed --;
            }

            count += needed;
        }
        return count;
    }

//    Time Complexity : O(n × log(maxGap / 10⁻⁶))
//                          Where : O(n) - Helper Function
//                                  O(log(maxGap / 10⁻⁶)) - Binary Search
//                                                                        Since we're working with doubles,
//                                                                        we stop when: high - low < 10⁻⁶
//    Space Complexity : O(1)
}
