import java.util.Scanner;

public class NestedSwitch {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int empId = input.nextInt();
    String depName = input.next();

    switch (empId){
        case 1 -> System.out.println("Anshul");
        case 2 -> System.out.println("Virat");
        case 3 -> {
            System.out.println("Employee Number 3");
            switch (depName){
                case "IT" -> System.out.println("IT Department");
                case "Management" -> System.out.println("Management Department");
                default -> System.out.println("Please enter valid Department...");
            }
        }
        default -> System.out.println("Please enter valid employee ID...");
    }
    }
}
