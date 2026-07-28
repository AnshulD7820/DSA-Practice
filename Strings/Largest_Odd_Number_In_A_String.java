//  GFG Problem : Largest odd number in string
//  Link : https://www.geeksforgeeks.org/problems/largest-odd-number-in-string/1

//  LeetCode Problem : 1903. Largest Odd Number in String
//  Link : https://leetcode.com/problems/largest-odd-number-in-string

public class Largest_Odd_Number_In_A_String {
    public static void main(String[] args) {

        String str = "52";

        System.out.println("Brute Force Approach : " + largestOddNumBrute(str));
        System.out.println("Optimal Approach : " + largestOddNumOptimal(str));
    }

//    Brute Force Approach :
    public static String largestOddNumBrute(String str){
        String ans = "";

        for (int i = 0; i < str.length(); i ++){
            for (int j = i; j < str.length(); j ++){
                String sub = str.substring(i, j + 1);

                char last = sub.charAt(sub.length() - 1);

                if((last - '0') % 2 == 1){
                    if(sub.length() > ans.length()){
                        ans = sub;
                    }
                }
            }
        }
        return ans;
    }

//    Time Complexity : O(n³)
//                      There are O(n²) substring and each substring takes : O(n)
//                      So overall time complexity becomes : O(n³) in the worst case
//    Space Complexity : O(n)

//    Optimal Approach :
    public static String largestOddNumOptimal(String str){
        for (int i = str.length() - 1; i >= 0; i --){
            char ch = str.charAt(i);

            if ((ch - '0') % 2 == 1){
                return str.substring(0, i + 1);
            }
        }
        return "";
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
