import java.util.*;

// LeetCode Problem : 229. Majority Element II
// Link : https://leetcode.com/problems/majority-element-ii

// GFG Problem : Majority Element - More Than n/3
// Link : https://www.geeksforgeeks.org/problems/majority-vote/1

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};

        System.out.println("Brute Force Approach : " + majorityElemBrute(arr));
        System.out.println("Better Approach : " + majorityElemBetter(arr));
        System.out.println("Optimal Approach : " + majorityElemOptimal(arr));
    }

//    Brute Force Approach :
    static List<Integer> majorityElemBrute(int[] arr){
        List<Integer> res = new ArrayList<>();

        for (int i = 0 ; i < arr.length ; i ++){
            if(res.contains(arr[i]))    // Skip Duplicates
                continue;
            int count = 0;
            for (int j = 0 ;  j < arr.length; j ++){
                if(arr[j] == arr[i])
                    count ++;
            }
            if(count > arr.length / 3)
                res.add(arr[i]);
        }
        return res;
    }
//    Time Complexity : O(n * n)
//    Space Complexity : O(1)

//    Better Approach :
    static List<Integer> majorityElemBetter(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);       // Count
        }
        for (int key : map.keySet()){
            if (map.get(key) > arr.length / 3){
                result.add(key);
            }
        }
        return result;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    static ArrayList<Integer> majorityElemOptimal(int[] arr){
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;

//        Step 1 : Candidates
        for (int num : arr){
            if(num == candidate1)
                count1 ++;
            else if(num == candidate2)
                count2 ++;
            else if (count1 == 0){
                candidate1 = num ;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1 --;
                count2 --;
            }
        }
//        Step 2 : Verify candidates actually exceeding n / 3
        count1 = 0;
        count2 = 0;

        for (int num : arr){
            if(num == candidate1)
                count1 ++;
            else if(num == candidate2)
                count2 ++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (count1 > arr.length / 3)
            result.add(candidate1);
        if(count2 > arr.length / 3)
            result.add(candidate2);

        return result;
    }
//    Time Complexity : O(n)
//    Space Complexity : O(1)

}
