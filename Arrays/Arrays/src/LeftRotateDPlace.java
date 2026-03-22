import java.util.Arrays;

public class LeftRotateDPlace {
    public static void main(String[] args) {
        int[] arr ={99,-1,-100,3};
        int d = 2;
//        leftRotateBrute(arr,d);
//        System.out.println(Arrays.toString(arr));

//        leftRotateBetter(arr,d);
//        System.out.println(Arrays.toString(arr));

        leftRotateOptimal(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    // Brute Force Approach:
    static void leftRotateBrute(int[] arr, int d){
        for (int i =0; i < d; i++){
            int temp = arr[0];
            for (int j =1; j < arr.length;j++){
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = temp;
        }
    }

    // Time Complexity : O(N*D)

    // Better Approach:
    static void leftRotateBetter(int[] arr, int d){
        int[] temp = new int[d];
        for(int i =0; i< d; i++){
            temp[i] = arr[i];
        }
        for (int i =d; i < arr.length;i++){
            arr[i-d] = arr[i];
        }
        for (int i=0; i< d;i++){
            arr[arr.length-d+i] = temp[i];
        }
    }

    // Time Complexity: O(N)
    // Space Complexity: O(D)

    // Optimal Approach:

    static void reverse(int[] arr, int start, int end){
        while (start <  end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end--;
        }
    }
    static void leftRotateOptimal(int[] arr, int d){
        reverse(arr, 0, d);
        reverse(arr, d + 1, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)

}
