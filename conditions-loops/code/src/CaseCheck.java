// Write a program to check whether the character is in lowercase or uppercase
import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char c = input.next().trim().charAt(0);

        if(c >= 'a' && c <= 'z'){
            System.out.println("Lowercase");
        }else {
            System.out.println("Uppercase");
        }
    }
}


