import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,7,8,9,1,5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low , pivotIndex -1);
            quickSort(arr, pivotIndex+1,high);
        }
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while (arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while (arr[j] > pivot && i>= low + 1){
                j--;
            }
            if(i < j){
                int temp1 = arr[i];
                arr[i] = arr[j];     // Here we have Swapped arr[i] and arr[j]
                arr[j] = temp1;
            }
        }
        int temp2 = arr[low];
        arr[low] = arr[j];     // Here we have Swapped arr[i] and arr[j]
        arr[j] = temp2;

        return j;
    }
}
