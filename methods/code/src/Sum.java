import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
//        sum();
//        int ans = sum2();
//        System.out.println(ans);

        int res = sum3(18, 45);
        System.out.println(res);

    }

    static int sum3(int a , int b){
        int sum = a + b ;
        return sum;
    }

    static int sum2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1 = input.nextInt();
        System.out.println("Enter Second Number: ");
        int num2 = input.nextInt();
        int sum = num1 + num2;
        return sum;
    }

    static void sum(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1 = input.nextInt();
        System.out.println("Enter Second Number: ");
        int num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum is: " + sum);
    }

}
