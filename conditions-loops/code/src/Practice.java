import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Find the largest number among three:
        // Approach 1:
//        System.out.println("Enter First Number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter Second Number: ");
//        int num2 = input.nextInt();
//        System.out.println("Enter Third Number: ");
//        int num3 = input.nextInt();
//
//        int maxNum = num1;
//        if(num2>maxNum){
//            maxNum = num2;
//        }
//        if (num3>maxNum){
//            maxNum = num3;
//        }
//        System.out.println("Maximum Number is: " + maxNum);

        //Approach 2: Using Math.max
//        System.out.println("Enter First Number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter Second Number: ");
//        int num2 = input.nextInt();
//        System.out.println("Enter Third Number: ");
//        int num3 = input.nextInt();
//
//        int maxNum =  Math.max(num3,(Math.max(num1, num2)));
//        System.out.println("Maximum number is: " + maxNum);

        // Alphabet Case Check
//        System.out.println("Enter an character: ");
//        char check = input.next().trim().charAt(0);
//
//        if(check > 'a' && check < 'z'){
//            System.out.println("LowerCase");
//        }else {
//            System.out.println("UpperCase");
//        }

         // Fibonacci Number
//        System.out.print("Enter A Number: ");
//        int num = input.nextInt();
//
//        int a  = 0;
//        int b = 1;
//        int count =  2;
//
//        while(count <= num){
//            int temp = b;
//            b = b + a ;
//            a = temp;
//            count ++;
//        }
//        System.out.println("Fibonacci Number is: " + b);

        // Counting Occurrence
//        System.out.println("Enter First Number: ");
//        int num1 = input.nextInt();
//        System.out.println("Enter Second Number: ");
//        int num2 = input.nextInt();
//
//        int count = 0;
//
//        while (num1> 0){
//            int rem = num1 % 10;
//            if(rem == num2){
//                count ++;
//            }
//            num1 /= 10;
//        }
//        System.out.println(count + " times second number digit is present in first number");

        // Reverse a number:

//        int number =  123456;
//        int reverse =  0;
//        while (number > 0){
//            int remainder = number % 10;
//            number /= 10;
//            reverse = reverse * 10 + remainder;
//        }
//        System.out.println("Reverse is: "  + reverse);

         // Calculator:
        int ans = 0;
        while (true){
            System.out.println("Enter the operator: ");
            char oper = input.next().trim().charAt(0);
            if(oper == '+' || oper == '-' || oper == '*' || oper == '/' || oper == '%'){
                System.out.println("Enter First Number: ");
                int num1 = input.nextInt();
                System.out.println("Enter Second Number: ");
                int num2 = input.nextInt();

                if(oper == '+'){
                    ans = num1 + num2;
                }
                if (oper == '-'){
                    ans = num1 - num2;
                }
                if (oper == '*'){
                    ans = num1 * num2;
                }
                if(oper == '/'){
                    if(num2 != 0){
                        ans = num1 / num2;
                    }else {
                        System.out.println("Number cannot be divided by zero");
                    }
                }
                if(oper == '%'){
                    ans = num1 % num2;
                }
                } else if (oper == 'x' || oper == 'X') {
                break;
            }else {
                System.out.println("INVALID INPUT");
            }
            System.out.println(ans);
        }
    }
}
