//  GFG Problem : Sort by Frequency
//  Link : https://www.geeksforgeeks.org/problems/sort-string-according-to-increasing-frequency/1

//  LeetCode Problem : 451. Sort Characters By Frequency
//  Link : https://leetcode.com/problems/sort-characters-by-frequency

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sort_Character_By_Frequency {
    public static void main(String[] args) {
        String s = "tree";

        System.out.println("Better Approach (HashMap + Sorting) : " + sortCharFreqBetter(s));
    }

//    Better Approach : (HashMap + Sorting)
    public static String sortCharFreqBetter(String s){
        HashMap<Character, Integer> map = new HashMap<>();
//        Count the frequency of character
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
//        Convert the map into list
        List<Character> list = new ArrayList<>(map.keySet());
//        Sort the list according to the frequency
        list.sort((a, b) -> map.get(b) - map.get(a));
//        Build answer
        StringBuilder ans = new StringBuilder();

        for (char ch : list){
            int freq = map.get(ch);

            while (freq -- > 0){
                ans.append(ch);
            }
        }
        return ans.toString();
    }

//    HashMap -> O(n)
//    Sorting -> O(k log k)
//                  Where k is the number of distinct character
//    Building answer -> O(n)
//    So overall time complexity becomes :
//                  Time Complexity : O(n + k log k)
//    Space Complexity : O(k)

// Optimal Approach: Bucket Sort

// I understand the concept of Bucket Sort, but I prefer using the HashMap + Sorting approach because it is simpler,
// easier to remember, and easier to implement.

// Bucket Sort requires handling additional implementation details such as:
// - Creating List<Character>[] buckets
// - Using frequency as the bucket index
// - Traversing buckets from the highest frequency to lowest
// - Handling null buckets

// Since HashMap + Sorting is accepted in most interviews,
// I will use that approach unless the interviewer specifically asks for the optimal O(n) Bucket Sort solution.

}
