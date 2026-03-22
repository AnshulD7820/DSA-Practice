import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
//        float num = input.nextFloat();
//            int num = input.nextFloat();
//              {This will provide an error because int is smaller than float , on the left side the value should be greater than the value on the right side}
//         int num = input.nextInt();
//        System.out.println(num);

        //Type Casting:
        // Compressing the bigger number into the smaller type explicitly is called as type casting.
//        int num = (int) (67.895f);
//        System.out.println(num);

        // automatic type promotion in expression
//        int a = 257;
//        byte b = (byte) (a);
//        System.out.println(b);   // 257 % 256 = 1 {Because byte can store 256 then }

//        byte a = 18;
//        byte b = 45;
//        byte c = 99;
//        int d = a * b / c ;
//        System.out.println(d);

        // #Java follows the uni-code principle

        int number = 'A';
        System.out.println(number);

       byte b = 42;
       char c = 'a';
       short s = 1048;
       int i = 102598;
       float f = 8.48f;
       double d = 0.1969;
       double result = (f * b) + (i / c) - (d * s);
        System.out.println((f * b) +" "+ (i / c) +" "+ (d * s));
        System.out.println(result);

    }
}
