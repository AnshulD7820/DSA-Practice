import java.util.ArrayList;
import java.util.Arrays;

// LeetCode Problem : 2149. Rearrange Array Elements by Sign
// Link : https://leetcode.com/problems/rearrange-array-elements-by-sign

// GFG Problem : Alternate Positive Negative
// Link : https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/0

public class RearrangeElemBySign {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};

        int[] arr1 = {1,2,-4,-5,3,6};

        System.out.println("Brute Force Approach : " + Arrays.toString(rearrangeElemBySignBrute(arr)));
        System.out.println("Optimal Approach : " + Arrays.toString(rearrangeElemBySignOptimal(arr)));

        System.out.println("Variant -> Unequal Count : " + Arrays.toString(rearrangeElemBySign2Variant(arr1)));

    }

    // Brute Force Approach :
    static int[] rearrangeElemBySignBrute(int[] arr){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : arr){
            if(num > 0)
                positive.add(num);
            else
                negative.add(num);
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length / 2; i ++){
            result[2 * i] = positive.get(i);
            result[2 * i + 1] = negative.get(i);
        }
        return result;
    }
    // Time Complexity : O [ (N) + (N/2) ]
    // Space Complexity : O(N)

    // Optimal Approach :
    static int[] rearrangeElemBySignOptimal(int[] arr){
        int[] result = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : arr){
            if(num > 0){
                result[posIndex] = num;
                posIndex += 2;
            }else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    // Second Variant : In this Problem, The count is not equal , means the number of positive and negative elements
    // This can be a follow-up Question...
    static int[] rearrangeElemBySign2Variant(int[] arr1){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : arr1){
            if(num > 0)
                positive.add(num);
            else
                negative.add(num);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[arr1.length];

        // alternate
        while (i < positive.size() && j < negative.size()){
            result[k++] = positive.get(i++);
            result[k++] = negative.get(j++);
        }

        // remaining positive
        while (i < positive.size()){
            result[k++] = positive.get(i++);
        }

        // remaining negative
        while (j < negative.size()){
            result[k++] = negative.get(j++);
        }
        return result;
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
