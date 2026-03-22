import java.util.Arrays;

public class LeftRotateOnePlace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        LeftRotateByOnePlace(arr);
//        System.out.println(Arrays.toString(arr));

        RightRotateByOnePlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void LeftRotateByOnePlace(int[] arr){
        int temp = arr[0];
        for (int i=1; i < arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    static void RightRotateByOnePlace(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i= arr.length -1 ;i > 0;i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

    }
}
