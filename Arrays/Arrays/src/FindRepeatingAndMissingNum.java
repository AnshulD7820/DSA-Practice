import java.util.ArrayList;
import java.util.Arrays;

// GFG Problem : Missing And Repeating
// Link : http://geeksforgeeks.org/problems/find-missing-and-repeating2512/1

public class FindRepeatingAndMissingNum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 2};

        System.out.println("Brute Force Approach : " + Arrays.toString(repeatingAndMissingBrute(arr)));
        System.out.println("Better Approach : " + Arrays.toString(repeatingAndMissingBetter(arr)));
        System.out.println("Optimal Approach : " + Arrays.toString(repeatingAndMissingOptimal(arr)));
    }

//    Brute Force Approach :
    static int[] repeatingAndMissingBrute(int[] arr){
        int n = arr.length;
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n; i ++){
            int count = 0;
            for (int j = 0; j < n; j ++){
                if (arr[j] == i)
                    count ++;
            }
            if(count == 2)
                repeating = i;
            if (count == 0)
                missing = i;
        }
        return new int[]{repeating,missing};
    }
//    Time Complexity : O(n²)
//    Space Complexity : O(1)

//    Better Approach : {Hashing}
    static int[] repeatingAndMissingBetter(int[] arr){
        int n = arr.length;
        int[] freq = new int[n + 1];
//        Count Occurrences
        for (int num : arr){
            freq[num]++;
        }
        int repeating = -1;
        int missing = -1;
        for (int i = 1; i <= n; i ++){
            if (freq[i] == 2)
                repeating = i;
            if (freq[i] == 0)
                missing = i;
        }
        return new int[]{repeating,missing};
    }
//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Optimal Approach : { Math Method }
    static int[] repeatingAndMissingOptimal(int[] arr){

        long n = arr.length;
//        Expected Values :
        long s = (long)n * (n + 1) / 2;                                                // Sum of first n natural number
        long s2 = (long)n * (n + 1) * (2*n + 1) / 6;                         // Sum of square of first n natural number
//        Actual Values :
        long sum = 0;
        long sqSum = 0;
        for (int num : arr){
            sum += num;
            sqSum += (long) num * num;
        }
//        Equation 1 : X - Y
        long eq1 = sum - s;
//        Equation 2 : X² - Y²
        long eq2 = sqSum - s2;
//        X + Y :
        eq2 = eq2 / eq1;
//        Repeating : X
        long X = (eq1 + eq2) / 2;
//        Missing : Y
        long Y = X - eq1;

        return new int[]{(int) X, (int) Y};
    }
//    Time Complexity : O(n)
//    Space Complexity : O(1)
}


//   If problem wants output to be in ArrayList<Integer>, Then just do this :
//   ArrayList<Integer> result = new ArrayList<>();
//   result.add((int)X);
//   result.add((int)Y);
//   return result;