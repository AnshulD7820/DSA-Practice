import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
//         String mess = greet();
//        System.out.println(mess);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = input.next();
        String personalised = greeting(name);
        System.out.println(personalised);
    }

    static String greeting(String name){
        String message = "Hello " + name + " How are you ?";
        return message;
    }

    static String greet(){
        String greeting = "How are you ?";
        return greeting;
    }
}
