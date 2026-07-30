//  GFG Problem : Isomorphic Strings
//  Link : https://www.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1

//  LeetCode Problem : 205. Isomorphic Strings
//  Link : https://leetcode.com/problems/isomorphic-strings

import java.util.HashMap;

public class Isomorphic_String {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        System.out.println("Brute Force Approach : " + isIsomorphicBrute(s, t));
        System.out.println("Optimal (HashMap) Approach : " + isIsomorphicOptimalHashMap(s, t));
        System.out.println("Optimal (Array) Approach : " + isIsomorphicOptimalArray(s, t));
    }

//    Brute Force Approach :
    public static boolean isIsomorphicBrute(String s, String t){
        int n = s.length();

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < i; j ++){
                if (s.charAt(i) == s.charAt(j) && t.charAt(i) != t.charAt(j)){
                    return false;
                }

                if (s.charAt(i) != s.charAt(j) && t.charAt(i) == t.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

//    Time Complexity : O(n²)
//    Space Complexity : O(1)

//    Optimal Approach : "USING TWO HASHMAP"
    public static boolean isIsomorphicOptimalHashMap(String s, String t){
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i ++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map1.containsKey(ch1)){
                if (map1.get(ch1) != ch2){
                    return false;
                }
            }
            else{
                map1.put(ch1, ch2);
            }

            if (map2.containsKey(ch2)){
                if (map2.get(ch2) != ch1){
                    return false;
                }
            }
            else{
                map2.put(ch2, ch1);
            }
        }
        return true;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach : "USING TWO ARRAY"
    public static boolean isIsomorphicOptimalArray(String s, String t){
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i ++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map1[ch1] != map2[ch2]){
                return false;
            }

            map1[ch1] = i + 1;
            map2[ch2] = i + 1;
        }
        return true;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)

//    Which Optimal Approach to use ?
//    =>    # If the problem states the strings contain English/ASCII characters:
//              Use the two-array solution.
//          # If the character set is unknown (Unicode, arbitrary symbols, objects, etc.):
//              Use the HashMap solution.
}
