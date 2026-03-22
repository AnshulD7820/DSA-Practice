import java.util.Arrays;

public class SortArrOf0_1_2 {
    public static void main(String[] args) {
        int[] arr={2, 0, 2, 1, 1, 0};

        System.out.println("Brute Force Approach : " + Arrays.toString(sortArrayBrute(arr)));
        System.out.println("Better Approach : " + Arrays.toString(sortArrayBetter(arr)));
        System.out.println("Optimal Approach : " + Arrays.toString(sortArrayOptimal(arr)));
    }

    // Brute Force Approach: Sort an array
    static int[] sortArrayBrute(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    // Time Complexity : O(N Log N)
    // Space Complexity : O(1)

    // Better Approach :
    static int[] sortArrayBetter(int[] arr){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int n : arr){
            if(n == 0)
                count0++;
            else if (n == 1)
                count1++;
            else
                count2++;
        }
        int index = 0;
        for (int i = 0 ; i < count0 ; i ++){
            arr[index++] = 0;
        }
        for (int i = 0; i < count1; i++){
            arr[index++] = 1;
        }
        for (int i =0;i < count2;i++){
            arr[index++] = 2;
        }
        return arr;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)

    // Optimal Approach: Dutch Flag Algorithm

    // arr[mid] == 0     -> swap(arr[low] and arr[mid)
    //                     low ++ and mid ++
    // arr[mid] == 1     -> mid ++
    // arr[mid] == 2     -> swap(arr[mid] and arr[high])
    //                      high --

    static int[] sortArrayOptimal(int[] arr){
        int low = 0 ;
        int mid = 0 ;
        int high = arr.length - 1;

        while (mid <= high){
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low ++;
                mid ++;
            } else if (arr[mid] == 1) {
                mid ++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high --;
            }
        }
        return arr;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
