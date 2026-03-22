import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        // Create an array
        int[] arr = {18, 45, 99, 7, 1, 333};
        change(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void change(int[] num){
        num[0] = 3;


    }
}
