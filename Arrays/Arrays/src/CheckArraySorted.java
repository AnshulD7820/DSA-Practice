import java.util.HashSet;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
//        System.out.println(checkArray(arr));

        int[] nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }

    static boolean checkArray(int[] arr){
        for (int i=1;i<arr.length;i++){

            if(arr[i] >= arr[i-1]){

            }else
                return false;
        }
        return true;
    }

    //LeetCode problem:
    static  boolean check(int[] nums){
        int count = 0;
        for (int i=0;i< nums.length - 1;i++){
            if(nums[i] > nums[i+1]){
                count ++;
            }
        }
        if(nums[nums.length - 1] > nums[0]){
            count++;
        }
        return count <= 1;
    }
}



