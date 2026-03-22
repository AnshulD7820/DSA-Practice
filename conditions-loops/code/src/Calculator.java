import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int ans = 0;
        while (true){
            System.out.print("Enter Operator: ");
            char oper = input.next().trim().charAt(0);

            if(oper == '+' || oper == '-' || oper == '*' || oper == '/' || oper == '%'){
                System.out.print("Enter First Number: ");
                int num1 = input.nextInt();
                System.out.print("Enter Second Number: ");
                int num2 = input.nextInt();

                if(oper == '+'){
                    ans = num1 + num2 ;
                }
                if(oper == '-'){
                    ans = num1 - num2 ;
                }
                if(oper == '*'){
                    ans = num1 * num2 ;
                }
                if(oper == '/'){
                    if(num2 != 0){
                        ans = num1 / num2;
                    }else{
                        System.out.println("Number cannot be divided by 0 ");
                    }
                }
                if(oper == '%'){
                    ans = num1 % num2 ;
                }
            }else if (oper == 'x' || oper == 'X'){
                break;
            }else {
                System.out.println("Invalid Input ");
            }
            System.out.println("Result is: " + ans);
        }
    }
}
