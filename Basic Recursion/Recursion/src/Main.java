import  java.util.*;

public class Main {
    public static void main(String[] args) {
        print(3);
        int n = 5;
        String name = "GFG";
        printNTimes(name, 0, n);
        int n1 = 5;
        print1ToN(1, 5);
        printNTo1(5);

        int n2 =5;
        SumFirstNP(n2,0);

        int n4 = 3;
//        System.out.println(SumFirstNF(n4));

//        System.out.println(Factorial(5));


        int[] arr ={1, 2, 3, 4, 5, 6,7};
        reverseArray(arr);
//        System.out.println(Arrays.toString(arr));

        String s = "RaceCar";
//        System.out.println(palindrome(s, 0, s.length() -1));


        String s1 = "0P";
//        System.out.println(palLeetcode(s1));

//        System.out.println(FibonacciNum(7));;



        System.out.println(addDigits(999));

        System.out.println(reverseString("Anshul"));

    }



    //RECURSION BASICS:
    static void print(int n){
        if(n == 0) return;                // Base Conditions
        print(n-1);                       // Recursive Call
//        System.out.println(n + " ");      // Work
    }

    // Print Name N times using Recursion
    static void printNTimes(String name, int count , int n){
        if(count == n){
            return;
        }
//            System.out.println(name);
        printNTimes(name, count + 1, n);
    }

    // Print 1 to N using Recursion
    static void print1ToN(int current , int n1){
        if(current > n1) return;
//        System.out.print(current  + " ");
        print1ToN(current + 1, n1);
    }

    // Print N to 1 using Recursion
    static void printNTo1(int current){
        if( current ==  0) return;
//        System.out.print(current + " ");
        printNTo1(current - 1);
    }

    // Sum of first N using recursion   : 1. parameter 2. functional
    // PARAMETERIZED WAY: Means using parameters
    static void SumFirstNP(int i, int sum){
        if(i == 0){
//            System.out.println(sum);
            return;
        }
        SumFirstNP(i - 1, sum + i);
    }

    // FUNCTIONAL WAY: just using n from the user
    static int SumFirstNF(int n4){
        if(n4 == 0) return 0;
        return n4 + SumFirstNF(n4-1);
    }

    // Factorial Of A Number Using Recursion:
    static int Factorial(int n5){
        if(n5 == 0) return 1;
        return  n5 * Factorial(n5-1);
    }

    // Reverse a given Array
    static void reverseArray(int[] arr){
        // Approach 1:
        int p1=0;
        int p2 = arr.length - 1;
        while (p1  < p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
//        System.out.println(Arrays.toString(arr));

        // Approach 2:
        int n = arr.length;
        int[] ans = new int[n];

        for (int i =0; i < n; i++){
            ans[i] = arr[n-1-i];
        }
//        System.out.println(Arrays.toString(ans));

    }

    // Check if the given String is Palindrome or not
        static boolean palindrome(String s, int left, int right){

        if(left == right) return true;
        if(s.charAt(left) != s.charAt(right)) return false;


        return palindrome(s, left + 1, right -1);
        }

        static boolean palLeetcode(String s){
        int left = 0;
        int right = s.length() -1 ;
        while(left < right ){
            if(!Character.isLetterOrDigit(s.charAt(left)))
                 left ++;
            else if (!Character.isLetterOrDigit(s.charAt(right)))
                right --;
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            else {
                left ++;
                right --;
            }
        }
            return true;
        }

      //Print Fibonacci Series up to Nth term
        static int FibonacciNum(int n){
        if (n <= 1) return n;

        int last = FibonacciNum(n-1);
        int sLast = FibonacciNum(n-2);

        return last + sLast;
        }

    static  void reverseString(char[] s5) {
        int left = 0;
        int  right = s5.length - 1 ;
        while(left < right){
         char temp = s5[left];
         s5[left] = s5[right];
         s5[right] = temp;
         left ++;
         right --;
        }
    }
    static int addDigits(int num) {

     if(num < 10 ) return num;
     int sum = 0;
     while(num > 0){
         sum += num % 10;
         num /= 10;
     }
     return addDigits(sum);
    }

    public static String reverseString(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = s.length() -1 ;
    while(left < right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left ++;
        right --;
    }
    return new String(arr);
    }

}
