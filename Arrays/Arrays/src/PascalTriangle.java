import java.util.ArrayList;
import java.util.List;

// LeetCode Problem : 118. Pascal's Triangle                                   (3rd Variation : Print Pascal's Triangle)
// Link : https://leetcode.com/problems/pascals-triangle

// LeetCode Problem : 119. Pascal's Triangle II                              (2nd Variation : Print the entire r-th row)
// Link : https://leetcode.com/problems/pascals-triangle-ii

// GFG Problem : Pascal Triangle                                                    (2nd Variation : Print the r-th row)
// Link : https://www.geeksforgeeks.org/problems/pascal-triangle0652/1


public class PascalTriangle {
    public static void main(String[] args) {

        int r  = 5;
        int c = 2;
        System.out.println("Element at row and column : " + pascalElement(r,c));

        int n = 3;
        System.out.println("Entire r-th row : " + pascalPrintRow(n));

        int n1 = 6 ;
        System.out.println("Pascal's Triangle : " + pascalTriangle(n1));

    }

//    Variation 1 — Given row r and column c, find the element at that position.
    static long pascalElement(int r , int  c){
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        for (int i = 0; i < k ; i ++){
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
//    Time Complexity : O(k) or O(c)
//    Space Complexity : O(1)

//    Variation 2 — Given row number r, print the entire r-th row.
    static List<Integer> pascalPrintRow(int n){
        List<Integer> row = new ArrayList<>();

        long res = 1;
        row.add(1);

        for (int i = 1 ;i <= n ; i++){
            res *= (n - i + 1);
            res /= i ;

            row.add((int) res);
        }
        return row;
    }
//    The above program is on zero based indexing... (LeetCode Solution)
//    Time Complexity : O(n)
//    Space Complexity : O(n)

//    Var 3 — Given n, generate the full Pascal's Triangle (all n rows).
    static List<List<Integer>> pascalTriangle(int n1){
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n1; i ++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0 ; j <= i ; j ++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
//    Time Complexity : O(n * n)
//    Space Complexity : O(n * n)
}
