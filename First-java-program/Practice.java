import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//  1. Write a program to print whether a number is even or odd, also take input from the user.
//        System.out.print("Enter a number : ");
//        int num1 = input.nextInt();
//        if (num1 % 2 == 0) {
//            System.out.println(num1 + " is an even number");
//        } else {
//            System.out.println(num1 + " is an odd number");
//        }

//  2. Take name as input and print a greeting message for that particular name.
//        System.out.print("Enter your name: ");
//        if(input.hasNextInt()){
//            System.out.println("Please enter a valid name");
//        }else{
//            String name = input.nextLine();
//            System.out.println("Hello " + name + " How are you ?");
//        }

//  3. Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
//        System.out.print("Enter Principal value : " );
//        double p = input.nextInt();
//        System.out.print("Enter Rate : " );
//        double r = input.nextInt();
//        System.out.print("Enter Time :" );
//        double t = input.nextInt();
//        double result = p * r * t / 100 ;
//        System.out.println("Simple Interest is " +result);

//  4. Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)
//        System.out.print("Enter First Number: ");
//        double firstNum = input.nextDouble();
//        System.out.print("Enter Second Number: ");
//        double secNum =  input.nextDouble();
//        System.out.print("Enter Operator (+,-,/,*): ");
//        char oper = input.next().charAt(0);
//
//        if(oper == '+'){
//            System.out.println("Addition is: " + (firstNum + secNum));
//        }
//        else if(oper == '-'){
//            System.out.println("Subtraction is: " + (firstNum - secNum));
//        }
//        else if(oper == '/'){
//            if(secNum != 0){
//                System.out.println("Division is: " + (firstNum/secNum));
//            }else {
//                System.out.println("Number cannot be divided by zero");
//            }
//        }
//        else if(oper == '*'){
//            System.out.println("Multiplication is: " + (firstNum * secNum));
//        }else{
//            System.out.println("INVALID OPERATOR");
//        }

//  5. Take 2 numbers as input and print the largest number.
//        System.out.print("Enter First Number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter Second Number: ");
//        double num2 = input.nextDouble();
//        if(num1 > num2){
//            System.out.println( num1 + " is greater");
//        }else if (num2 > num1){
//            System.out.println(num2 + " is greater");
//        }else {
//            System.out.println("Numbers are equal");
//        }

//  6. Input currency in rupees and output in USD.
//        System.out.print("Enter Currency in rupees: ");
//        double curr = input.nextDouble();
//        double usdCov = curr * 0.01099;
//        System.out.println("Conversion of rupees into USD is: " + usdCov);


        // Check whether a number is prime or not:
//        System.out.println("Enter a number:");
//        int number = input.nextInt();
//
//        if(number<=1){
//            System.out.println(number + " is neither prime nor composite");
//            return;
//        }
//        int c = 2;
//        if(number == 4){
//            System.out.println(number + " is not a prime number");
//        }else{
//            while(c*c< number){
//               if(number % c == 0){
//                   System.out.println(number + " is not a prime number");
//                   return;
//               }
//               c = c+1;
//            }
//            if(c*c > number){
//                System.out.println(number + " is a prime number");
//
//            }
//        }


    }

}
