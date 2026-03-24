import java.util.Arrays;

// LeetCode Problem : 31. Next Permutation.
// Link : https://leetcode.com/problems/next-permutation

// GFG Problem : Next Permutation.
// Link : https://www.geeksforgeeks.org/problems/next-permutation5226/1

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {3,2,1};

        System.out.println("Optimal Approach : " + Arrays.toString(nextPermutationOptimal(arr)));
        System.out.println("LeetCode And GFG Solution : " + Arrays.toString(nextPermutationLeetCodeAndGFG(arr)));
    }

//  Brute Force Approach :
//  -> First we have to generate all permutation , then sort and after that we have to find next permutation.
//  -> Time Complexity : O(n! × n)
//  -> Space Complexity : O(n!)
//  -> This is completely impractical for large value of n.

//  Optimal Approach :
    static int[] nextPermutationOptimal(int[] arr){
        int n = arr.length;
        int index = -1;

//  Step 1 : Find the Breakpoint
        for (int i = n - 2 ; i >= 0 ; i --){
            if(arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }
//  Edge Case: If no breakpoint exist, the array is already the last permutation, So just reverse the entire array.
        if (index == -1){
//             reverse (arr, 0, n-1)
            int i = 0;
            int j = n - 1;
            while (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i ++;
                j --;

                return arr;
            }
        }
//  Step 2 : From the right again, Find the smallest number that is greater than the arr[i] and swap it
        for (int i = n -1 ; i > index ; i --){
            if(arr[i] > arr[index]){
//          Swap (arr, i , index)
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

                break;
            }
        }
//  Step 3 : reverse the remaining the right part
//         reverse(arr, index + 1, n - 1)
        int i = index + 1;
        int j = n - 1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return arr;
    }

//     Time Complexity : O(3N)
//     Space Complexity : O(1)

//    LeetCode And GFG Solution :
    static int[] nextPermutationLeetCodeAndGFG(int[] arr){
        int n = arr.length;
        int index = -1;

//  Step 1 : Find the Breakpoint
        for (int i = n - 2 ; i >= 0 ; i --){
            if(arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }
//  Step 2 : From the right again, Find the smallest number that is greater than the arr[i] and swap it
        if(index != -1){
            for (int i = n -1 ; i > index ; i --){
                if(arr[i] > arr[index]){
//                  Swap (arr, i , index)
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;

                    break;
                }
            }
        }
//  Step 3 : reverse the remaining the right part
//         reverse(arr, index + 1, n - 1)
        int i = index + 1;
        int j = n - 1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

}
