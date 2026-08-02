//  GFG Problem : Roman to Integer
//  Link : https://www.geeksforgeeks.org/problems/roman-number-to-integer3201/1

//  LeetCode Problem : 13. Roman to Integer
//  Link : https://leetcode.com/problems/roman-to-integer

import java.util.HashMap;

public class Roman_To_Integer {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Optimal Approach : " + romanToInt(s));
    }

//    Optimal Approach :
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length() - 1; i ++){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                ans -= map.get(s.charAt(i));
            }
            else{
                ans += map.get(s.charAt(i));
            }
        }
        return ans + map.get(s.charAt(s.length() - 1));
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1) (The HashMap stores only the 7 Roman numeral symbols, so its size is constant.)
}
