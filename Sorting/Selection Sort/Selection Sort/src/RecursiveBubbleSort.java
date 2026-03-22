import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        int n = arr.length;
//        bubbleSort(arr,n);
//        System.out.println(Arrays.toString(arr));

        OptimizedRecursiveBubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr, int n){
        if(n == 1)  // base case: array of size 1 is already sorted that's why we have taken 1
            return;
        for (int j = 0; j<= n - 2; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }

        }
        bubbleSort(arr, n-1);
    }
    static void OptimizedRecursiveBubbleSort(int[] arr, int n){
        if(n==1)
            return;
        boolean isSwapped = false;
        for (int j=0; j<= n-2;j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;

                isSwapped = true;
            }
        }
            if (!isSwapped)
                return;
        OptimizedRecursiveBubbleSort(arr,n-1);
    }
}
