import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr ={1, 2, 4};
        System.out.println(removeDuplicates(arr));

//        System.out.println(removeDup(arr));
    }

    //Brute Force Approach:
//    static int removeDup(int[] arr){
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : arr){
//            set.add(num);
//        }
//        int i =0;
//        for (int num : set){
//            arr[i++] = num;
//        }
//        return set.size();
//    }

    static ArrayList<Integer> removeDuplicates(int[] arr){

        int i =0;
        for (int j=1;j<arr.length;j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int k = 0; k <= i; k++) {
            ans.add(arr[k]);
        }

       return ans;
    }
}
