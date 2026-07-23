public class Basic_Problems {
    public static void main(String[] args) {
        String str = "madam";

        System.out.print("Print Each Character : ");
        printChar(str);
        System.out.println();

        System.out.println("Count Length : " + countLength(str));

        System.out.println("Count Vowels : " + countVowels(str));

        System.out.print("Reverse String : ");
        reverseString(str);

        System.out.print("Check Palindrome : ");
        checkPalindrome(str);

    }

//    Problem 1 : Print Each Character
    public static void printChar(String str){
        for (int i = 0; i < str.length(); i ++){
            char ch = str.charAt(i);
            System.out.print(ch);
        }
    }

//    Problem 2 : Count Length Without Using length()
    public static int countLength(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i ++){
            count++;
        }
        return count;
    }

//    Problem 3 : Count Vowels
    public static int countVowels(String str){
        int count = 0;

        for (int i = 0; i < str.length(); i ++){
            char ch = str.charAt(i);

            if(
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
            ){
                count ++;
            }
        }
        return count;
    }

//    Problem 4 : Reverse a String
    public static void reverseString(String str){
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i --){
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }

//    Problem 5 : Check Palindrome
    public static void checkPalindrome(String str){
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i --){
            reverse += str.charAt(i);
        }

        if(reverse.equals(str)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
