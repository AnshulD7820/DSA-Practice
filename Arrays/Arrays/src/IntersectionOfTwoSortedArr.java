import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfTwoSortedArr {
    public static void main(String[] args) {

        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

//        System.out.println(IntersectionBrute(arr1,arr2));
//        System.out.println(IntersectionOptimal(arr1, arr2));
//        System.out.println(IntersectionOptimalGFG(arr1, arr2));
//        System.out.println(Arrays.toString(intersection(arr1, arr2)));
//        System.out.println(Arrays.toString(intersect(arr1, arr2)));

    }


    // Brute Force Approach:
    static ArrayList<Integer> IntersectionBrute(int[] arr1, int[] arr2){

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i< arr1.length;i++){
            for (int j = 0;j< arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    result.add(arr1[i]);
                    break;
                }
            }
        }
        return result;
    }

    // Time Complexity: O( x * y )    ....very slow

    static ArrayList<Integer> IntersectionOptimal(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
            else{
               result.add(arr2[j]);
                i++;
                j++;
            }
        }
        return result;
    }

    // In this GFG problem , duplication is not allowed
    static ArrayList<Integer> IntersectionOptimalGFG(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
            else{
                if(result.size() == 0 || result.get(result.size() - 1) != arr1[i]){
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return result;
    }

    // LeetCode Problem : 349
    static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1){
            set.add(num);
        }
        for (int num : nums2){
            if(set.contains(num)){
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i =0;
        for (int num : result){
            res[i++] = num;
        }
        return res;
    }

    //LeetCode Problem : 350
    static int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[result.size()];
        int i =0;
        for (int num : result){
            res[i++]= num;
        }
        return res;
    }
}
