import java.util.Stack;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        CountDigit(77299);
        RevDig(-12345);
        Palindrome(131);
        Armstrong(153);
        printAllDiv(36);
        printAllDiv2(36);
        checkPrime(7);
        GCD(3,6);
        print(3);
    }

    public static void CountDigit(int n){
        int count = 0;
        while (n > 0){
            n /= 10;
            count ++;
        }
//        System.out.println(count);
    }


    // LEETCODE QUESTION:
    public static void RevDig (int n){
        int count = 0;
        int rev = 0;
        while (n != 0){

            int rem = n % 10;
            n /= 10;
            count ++;
            if(rev >  Integer.MAX_VALUE/10){
                return ;
            }
            if(rev == Integer.MAX_VALUE / 10 && rem>7){
               return;
            }
            if (rev < Integer.MIN_VALUE / 10){
               return;
            }
            if (rev == Integer.MIN_VALUE / 10 && rem < -8){
                return;
            }
            rev = (rev * 10) + rem;

        }
//        System.out.println( rev);
    }

    static void  Palindrome(int n){
        int count =0;
        int dup = n;
        int rev = 0;

        while(n != 0){
            int rem = n % 10 ;
            n /= 10;
            count ++;
            rev = (rev * 10) + rem;
        }
       if(dup == rev){
//           System.out.println("Palindrome");
       }else{
//           System.out.println("Not a Palindrome");
       }
    }

    static void Armstrong(int n){
        int dup= n;
        int rev= 0;
        int sum =0;
        while(n > 0){
            int rem = n % 10 ;
            n /= 10;
            rev = (rev * 10) + rem;
            sum = sum + (rem * rem * rem);
        }
        if(dup == sum){
//            System.out.println("true");
        }else {
//            System.out.println("false");
        }
    }

    static void printAllDiv(int n){
        for (int i=1; i<=n;i++){
            if( n % i == 0){
//                System.out.println(i);
            }
        }
    }

    static void printAllDiv2(int n){
        Stack<Integer> st = new Stack<>();
        for (int i=1;i*i <= n; i++){
            if(n % i == 0){
                st.push(i);
                if((n/i) != i){
                    st.push(n/i);
                }
            }
        }
        Collections.sort(st);
//        for (int num : st) System.out.print(num + " ");
    }

    static void checkPrime(int n){
        int count =0;
        for (int i=1; i*i <= n;i++){
            if(n % i == 0){
                count ++;
                if((n/i) !=i){
                    count ++;
                }
            }
        }
//        if( count == 2) System.out.println("Prime");
//        else System.out.println("Not Prime");
    }

    static void GCD(int a, int b){
        while (a > 0 && b > 0){
            if(a > b){
                a = a % b;
            }else {
                b = b % a;
            }
        }
//        if(a == 0) System.out.println(b);
//        else System.out.println(a);
    }

}
