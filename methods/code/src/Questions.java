import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
//        boolean ans  = prime(num);
//        System.out.println(ans);

        System.out.println(armstrong(num));

    }

    // Prime Number:
    static boolean prime(int num){
        if(num <= 1){
            return false;
        }
        int c = 2;
        while ( c * c <= num){
            if(num % c == 0){
            return false;
            }
        c++;
        }
        return c * c >= num;
    }

     /*Armstrong Number:
     To check a three-digit number whether it is an Armstrong number or not, we have to:
     take cube of individual digits and then sum it, if the answer we get is the number that
     we have to check the Armstrong number , if it is matching , then we can say that
    the given number is Armstrong number.*/

    static boolean armstrong(int n){
        int original = n;
        int sum = 0;
        while (n>0){
            int rem = n % 10;
            n /= 10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }
}
