//  GFG Problem : Implement Atoi
//  Link : https://www.geeksforgeeks.org/problems/implement-atoi/1

//  LeetCode Problem : 8. String to Integer (atoi)
//  Link : https://leetcode.com/problems/string-to-integer-atoi

public class String_To_Integer_atoi {
    public static void main(String[] args) {
        String s = "1337c0d3";

        System.out.println("Optimal Approach : " + myAtoi(s));
    }

//    Optimal Approach :
    public static int myAtoi(String s){
        int i = 0;
        int n = s.length();

//        Ignore Leading Space:
        while (i < n  && s.charAt(i) == ' '){
            i ++;
        }
//        Check Sign:
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if (s.charAt(i) == '-'){
                sign = -1;
            }
            i ++;
        }
//        Read only digits:
        int number  = 0;
        while (i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
//            Check the overflow conditions:
            if (
                    number > Integer.MAX_VALUE / 10 ||
                    (number == Integer.MAX_VALUE / 10 && digit > 7)
            ){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
//            Build the number:
            number = number * 10 + digit;

            i ++;
        }
        return number * sign;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
