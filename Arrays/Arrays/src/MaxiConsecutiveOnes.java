public class MaxiConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0 ,1, 0, 0, 1};
        System.out.println(maxOnes(arr));

        System.out.println(maxConsecBits(arr));
    }

    static int maxOnes(int[] arr){
        int count = 0;
        int max = 0;
        for (int i = 0; i< arr.length; i++){
            if(arr[i] == 1 ){
                count++;
            }else {
              count = 0;
            }
            max = Math.max(count,max);
        }
        return max;
    }

    // GFG Problem:
    static int maxConsecBits(int[] arr){
        if (arr.length == 0)
            return 0;
        int maxCount = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }
}
