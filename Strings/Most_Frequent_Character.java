//  GFG Problem : Most Frequent Character
//  Link : https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1

import java.util.HashMap;

public class Most_Frequent_Character {
    public static void main(String[] args) {
        String str = "testsample";

        System.out.println("Brute Force Approach : " + frequentCharBrute(str));
        System.out.println("Optimal Approach : " + frequentCharOptimal(str));
        System.out.println("HashMap Approach : " + frequentCharHashMap(str));
    }

//    The Problem Clearly States That : If more than one character occurs the maximum number of times then print
//    the lexicographically smaller character.

//    Brute Force Approach :
    public static char frequentCharBrute(String str){
        int maxFrequency = 0;
        char ans = '\0';

        for (int i = 0; i < str.length(); i ++){
            int count = 0;
            for (int j = 0; j < str.length(); j ++){
                if(str.charAt(i) == str.charAt(j)){
                    count ++;
                }
            }
            if(count > maxFrequency){
                maxFrequency = count;
                ans = str.charAt(i);
            }
            else if (count == maxFrequency && str.charAt(i) < ans){
                ans = str.charAt(i);
            }
        }
        return ans;
    }

//    Time Complexity : O(n²)
//    Space Complexity : O(1)

//    Optimal Approach :
    public static char frequentCharOptimal(String str){
        int[] freq = new int[26];

//        Count Frequency of each character
        for (char ch : str.toCharArray()){
            freq[ch - 'a'] ++;
        }

        int maxFreq = 0;
        char ans = '\0';

//        Traverse from 'a' to 'z'
        for (int i = 0; i < 26; i ++){
            if (freq[i] > maxFreq){
                maxFreq = freq[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)


//    If Characters are not limited to the LowerCase:-
//    ->    Suppose the string contains:
//          ->  UpperCase
//          ->  Digits
//          ->  Symbols
//    Then Use HashMap

    public static char frequentCharHashMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = 0;
        char ans = '\0';

        for (char ch : str.toCharArray()){
            if(map.get(ch) > maxFreq){
                maxFreq = map.get(ch);
                ans = ch;
            }
        }
        return ans;
    }
}
