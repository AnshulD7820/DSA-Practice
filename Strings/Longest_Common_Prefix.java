//  GFG Problem : Longest Common Prefix of Strings
//  Link : https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1

//  LeetCode Problem : 14. Longest Common Prefix
//  Link : https://leetcode.com/problems/longest-common-prefix

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};

        System.out.println("Brute Force Approach : " + longestCommonPrefixBrute(str));
        System.out.println("Optimal Approach : " + longestCommonPrefixOptimal(str));
    }

//    Brute Force Approach :
    public static String longestCommonPrefixBrute(String[] str){
        String prefix = "";

        String first = str[0];

        for (int i = 0; i < first.length(); i ++){
            prefix += first.charAt(i);

            for (String word : str){
                if(!word.startsWith(prefix)){
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }

//    Time Complexity : O(n × m²)
//                      Where n = length of the string
//                            m = length of the first string
//    Space Complexity : O(1)

//    Optimal Approach :
    public static String longestCommonPrefixOptimal(String[] str){
        String first = str[0];

        for (int i = 0; i < first.length(); i ++){
            char ch = first.charAt(i);

            for (int j = 1; j < str.length; j ++){
                if (i == str[j].length() || str[j].charAt(i) != ch){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

//    Time Complexity : O(n × m)
//                      Where n = length of the string
//                            m = length of the shortest string (or the common prefix length)
//    Space Complexity : O(1)
}
