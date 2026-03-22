import java.lang.foreign.Arena;
import java.util.*;
import java.util.ArrayList;

public class MovesZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
//        moveZeroBrute(arr);
//        System.out.println(Arrays.toString(arr));

        moveZeroOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Brute Force Approach:
    static void moveZeroBrute(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;
        for (int i = 0; i< n;i++){
            if(arr[i] != 0){
                temp[index++] = arr[i];
             }
        }
        int nz = temp.length;
        for (int i =0; i<nz;i++){
            arr[i] = temp[i];
        }
        for (int i = nz; i < n;i++){
            arr[i] = 0;
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)

    static void moveZeroOptimal(int[] arr){
        int n = arr.length;
        int j =-1;
        for (int  i =0; i<n;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1) return;   // If no non-zero numbers
        for (int i = j + 1; i < n ; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
}
