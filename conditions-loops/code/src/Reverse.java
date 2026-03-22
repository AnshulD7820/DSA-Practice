// Write a program to reverse a number
public class Reverse {
    public static void main(String[] args) {
        int num =  89745;
        int rev = 0;

            while (num > 0){
                int rem = num % 10;
                num /= 10;

                rev = rev * 10 + rem;   // the core concept in this question was how to get 4 after 5 together,
                // so when we multiply 5 to 10 it gives us 50 and after that  when we add the remainder which
                // will be the next number, in this that is 4 and when we add this 4 to 50 , it gives me 54 that
                // is what we actually want
            }
        System.out.println(rev);
    }
}
