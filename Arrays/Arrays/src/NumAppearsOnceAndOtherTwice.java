import java.util.HashMap;

public class NumAppearsOnceAndOtherTwice {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99};
        System.out.println("Brute Force Approach : " + NumberAppearBrute(arr));
        System.out.println("Better Approach : " + NumberAppearBetter(arr));
        System.out.println("Optimal Approach : " + NumberAppearOptimal(arr));
    }

    // Brute Force Approach: Iterating throughout the array
    static int NumberAppearBrute(int[] arr){

        for (int i =0; i < arr.length;i++){
           int  num = arr[i];
           int count = 0;
            for (int j=0; j< arr.length;j++){
                if(arr[j] == num){
                    count ++;
                }
            }
            if(count == 1) return num;
        }
        return -1;
    }
    // Time complexity =  O(N * N)
    // Space complexity =  O(1)

    // Better Approach : Using Hashing
    static int NumberAppearBetter(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0 )+ 1);
        }
        for (int num : arr){
            if(map.get(num) == 1)
                return num;
        }
        return -1;
    }
    //Time Complexity : O(N + N)
    // Space Complexity : O(max + 1)

    // Optimal Approach: Using XOR
    static int NumberAppearOptimal(int[] arr){
        int xor = 0;
        for (int i = 0 ; i < arr.length; i++){
            xor ^= arr[i];
        }
        return xor;
    }
}
