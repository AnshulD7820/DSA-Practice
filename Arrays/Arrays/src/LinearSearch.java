public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 6, 7 , 8 , 4 , 1};
        int x = 4;
        System.out.println( occurrence(arr, x));
    }
    static int occurrence(int[] arr, int x){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
