import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        greeting();
    }
    static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.println("Hello " + name + " How are you ?");

    }
}
