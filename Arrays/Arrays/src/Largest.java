import java.util.Arrays;

public class Largest {
    public static void main(String[] args) {
        int[] arr = {7,9,8,6,4,1,5,9};
        System.out.println("Largest: " + largest(arr));
        System.out.println("Second Largest: " + secondLargest(arr));
    }

    // Brute Force Approach:
//    static int largest(int[] arr){
//        Arrays.sort(arr);
//        return arr[arr.length - 1];
//    }

    // Optimal Approach:
    static int largest(int[] arr){
        int largest =arr[0];
        for (int i=0;i< arr.length;i++){
            if(arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    //Brute Force Approach:
//    static int secondLargest(int[] arr){
//        Arrays.sort(arr);
//        int largest = arr[arr.length - 1];
//        for (int i = arr.length - 2; i >= 0; i--){
//            if(arr[i] != largest){
//                return arr[i];
//            }
//        }
//        return -1;
//    }


    //Optimal Approach:
    static int secondLargest(int[] arr){
        int largest = arr[0];
        int sLargest = -1;
        // If the array is not containing any negative element then use -1, Otherwise use Integer.MAX_VALUE.
        for (int i=0;i< arr.length;i++){
            if(arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > sLargest){
                sLargest = arr[i];
            }
        }
        return sLargest;
    }
}
