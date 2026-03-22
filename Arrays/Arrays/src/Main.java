import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // GFG PROBLEM:
        ArrayList<Integer> result = new ArrayList<>();
        int[] arr = {12,4,6,9,3};

        int small = smallest(arr);
        int secSmall = secondSmallest(arr);

        if(secSmall == -1){
        result.add(-1);
//        return result;
            return;
        }

        result.add(small);
        result.add(secSmall);
        System.out.println(result);


    }
    static int smallest(int[] arr){
        int smallest = arr[0];
        for (int i = 0; i< arr.length;i++){
            if((arr[i] < smallest))
                smallest = arr[i];
        }
        return smallest;
    }
    static int secondSmallest(int[] arr){

        if(arr.length < 2){
            return -1;
        }
        int smallest1 = Integer.MAX_VALUE;
        int secSmall = Integer.MAX_VALUE;
        for (int i=0;i< arr.length;i++){
            if(arr[i] < smallest1){
                secSmall = smallest1;
                smallest1 = arr[i];
            } else if (arr[i] != smallest1 && arr[i] < secSmall) {
                secSmall=arr[i];
            }
        }
        if(secSmall == Integer.MAX_VALUE)
            return -1;
        return secSmall;
    }
}