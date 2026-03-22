import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class UnionTwoSortedArr {
    public static void main(String[] args) {
       int x = 3;
       int y = 3;

       int[] arr1 = {1, 2, 2, 3, 4};
       int[] arr2 = {2, 2, 4, 6, 7, 8};


        System.out.println( findUnionBrute(arr1,arr2,x,y));
        System.out.println( unionOptimal(arr1,arr2,x,y));
        System.out.println(union(arr1,arr2 , x, y));

    }

    // Brute Force Approach:  Using Map =>
    static List<Integer> findUnionBrute(int[] arr1, int[] arr2, int x , int y){

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int i =0; i<x;i++){
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i =0;i<y;i++){
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
        }
        List<Integer> Union = new ArrayList<>();
        for (int num : freq.keySet()){
            Union.add(num);
        }
        return Union;
    }

    // Time Complexity : O(xlogn + ylogn) + O(x + y)
    // Space Complexity : O(x + y) + O(x + y)

    // Brute Force Approach: Using Set =>
    static ArrayList<Integer> union(int[] arr1, int[] arr2 , int x , int y){
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1){
            set.add(num);
        }
        for (int num : arr2){
            set.add(num);
        }
        return new ArrayList<>(set);

    }

    // Time Complexity : O(x + y)
    // Space Complexity : O(x + y)


    static ArrayList<Integer> unionOptimal(int[] arr1, int[] arr2, int x ,int y){
        int i = 0;
        int j = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i < x && j < y){
            if(arr1[i] < arr2[j]){
                if(result.size() == 0 || result.get(result.size() - 1) != arr1[i]){
                    result.add(arr1[i]);
                }
                i++;
            }
            else {
                if(result.size() == 0 || result.get(result.size() - 1) != arr2[j]){
                        result.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < x){
            if(result.size() == 0 || result.get(result.size() - 1) != arr1[i]){
                result.add(arr1[i]);
            }
            i++;
        }
        while (j < y){
            if(result.size() == 0 || result.get(result.size() - 1) != arr2[j]){
                result.add(arr2[j]);
            }
            j++;
        }
        return result;
    }

    // Time Complexity : O(x + y)
    // Space Complexity : O(x + y)
}
