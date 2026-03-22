public class Smallest {
    public static void main(String[] args) {
        int[] arr = {18,1,9,5,3,7};
        System.out.println("Smallest: "+ smallest(arr));
        System.out.println("Second Smallest: "+ secondSmallest(arr));
    }

    static int smallest(int[] arr){
        int smallest = arr[0];
        for (int i =0;i< arr.length;i++){
            if(arr[i] < smallest)
                smallest=arr[i];
        }
        return smallest;
    }

    static int secondSmallest(int[] arr){
        int small = arr[0];
        int secSmall = Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++){
            if(arr[i] < small){
                secSmall = small;
                small = arr[i];
            }else if(arr[i] != small && arr[i] < secSmall){
                secSmall = arr[i];
            }
        }
        return secSmall;
    }
}
