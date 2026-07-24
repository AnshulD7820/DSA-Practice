//  GFG Problem : Reverse Words
//  Link : https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

//  LeetCode Problem : 151. Reverse Words in a String
//  Link : https://leetcode.com/problems/reverse-words-in-a-string

public class Reverse_Words_In_String {
    public static void main(String[] args) {
        String str = "   hello   world   ";

        System.out.println("Brute Force Approach : "  + reverseWordsBrute(str));
        System.out.println("Optimal Approach : " + reverseWordsOptimal(str));
    }

//    Brute Force Approach :
    public static String reverseWordsBrute(String str){
        String[] words = str.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i --){
            ans.append(words[i]);

            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach :
    public static String reverseWordsOptimal(String str){
        StringBuilder ans = new StringBuilder();
        int i = str.length() - 1;

        while(i >= 0){
//            Remove all the trailing space
            while (i >= 0 && str.charAt(i) == ' '){
                i --;
            }
            if( i < 0){
                break;
            }
            int j = i;
//            Find the start index of the word
            while (j >= 0 && str.charAt(j) != ' '){
                j --;
            }
            ans.append(str.substring(j + 1, i + 1));

            while(j >= 0 && str.charAt(j) == ' '){
                j --;
            }

            if(j >= 0){
                ans.append(' ');
            }
            i = j;
        }
        return ans.toString();
    }

//    Time Complexity : O(n)
//    Space Complexity : O(n)
}
