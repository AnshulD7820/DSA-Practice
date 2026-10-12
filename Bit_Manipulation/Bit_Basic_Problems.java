//  GFG Problem : Decimal to Binary
//  Link : https://www.geeksforgeeks.org/problems/decimal-to-binary-1587115620/1

//  GFG Problem : Binary to Decimal
//  Link : https://www.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1

public class Bit_Basic_Problems {
    static void main(String[] args) {
        int number = 13;
        String n = "1101";

        int n1 = 13;
        int n2 = 7;

        System.out.println("Decimal to Binary : " + decimalToBinary(number));

        System.out.println("Binary to Decimal : " + binaryToDecimal(n));

        System.out.print("AND Operator : ");
        System.out.println(n1 & n2);

        System.out.print("OR Operator : ");
        System.out.println(n1 | n2);

        System.out.print("XOR Operator : ");
        System.out.println(n1 ^ n2);

        int x = 13;
        int k = 1;
        System.out.print("Right Shift Operator : ");
        System.out.println(x >> k);

        System.out.print("Left Shift Operator : ");
        System.out.println(x << k);

        System.out.print("Not Operator : ");
        System.out.println(~ number);
    }

//    Convert Decimal To Binary :
    public static String decimalToBinary (int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while (number > 0)  {
            binary.append(number % 2);
            number = number / 2;
        }

        return binary.reverse().toString();
    }

//    Time Complexity : O(log n)
//    Space Complexity : O(log n)

//    Convert Binary To Decimal :
    public static int binaryToDecimal (String n) {
        int decimal = 0;

        for (int i = 0; i < n.length(); i ++) {
            decimal = decimal * 2 + (n.charAt(i) - '0');
        }

        return decimal;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
}
