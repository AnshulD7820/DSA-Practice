import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {13,46,24,52,20,9};
        SelectionSort(arr1);
//        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {13,46,24,52,20,9};
        BubbleSort(arr2);
//        System.out.println(Arrays.toString(arr2));

        int[] arr3 ={14,9,15,12,6,8,0,13,6,0};
        InsertionSort(arr3);
//        System.out.println(Arrays.toString(arr3));

        // Practice :
        int[] arr4 = {64, 25, 12, 22, 11};
        selectionSortP(arr4);
//        System.out.println(Arrays.toString(arr4));

        int[] arr5 ={5,4,3,2,1};
        bubbleSortP(arr5);
//        System.out.println(Arrays.toString(arr5));

        int[] arr6 ={5,4,3,2,1};
        bubbleSortOptimizedP(arr6);
//        System.out.println(Arrays.toString(arr6));

        int[] arr7 ={14,9,15,12,6,8,13};
        insertionSortP(arr7);
//        System.out.println(Arrays.toString(arr7));
    }

    static void SelectionSort(int[] arr1){
        for (int i = 0;i<= arr1.length-2;i++){
            int min = i;
            for (int j=i;j<= arr1.length-1;j++){
                if(arr1[j] < arr1[min])
                    min = j;
            }
            int temp = arr1[min];
            arr1[min] = arr1[i];
            arr1[i] = temp;
        }
    }

    static void BubbleSort(int[] arr2){
        for (int i=0;i< arr2.length-1;i++){
            for (int j=0;j< arr2.length - i -1; j++){
                if(arr2[j] > arr2[j+1]){
                    int temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
            }
        }
    }

    static void InsertionSort(int[] arr3){
        for (int i=0;i<= arr3.length-1;i++){
            int j = i;
            while (j>0 && arr3[j-1] > arr3[j]){
                int temp = arr3[j];
                arr3[j] = arr3[j-1];
                arr3[j-1] = temp;
                j--;
            }
        }
    }

    // Practice:
    // 1 . Selection Sort:
    static void selectionSortP(int[] arr4){
        for (int i=0;i<= arr4.length-2;i++){
            int min =i;
            for (int j=i;j<= arr4.length-1;j++){
                if(arr4[j] < arr4[min])
                    min = j;
            }
            int temp = arr4[min];
            arr4[min] = arr4[i];
            arr4[i] = temp;
        }
    }
    //2. Bubble Sort:
    static void bubbleSortP(int[] arr5){
        for (int i=0;i< arr5.length-1;i++){
            for (int j=0;j< arr5.length-i-1;j++){
                if(arr5[j] > arr5[j+1]){
                    int temp = arr5[j];
                    arr5[j] = arr5[j+1];
                    arr5[j+1] = temp;
                }

            }
        }
    }
    static void bubbleSortOptimizedP(int[] arr6){
        for (int i=0;i< arr6.length-1;i++){
            int swap = 0;
            for(int j=0;j< arr6.length-i-1;j++){
                if(arr6[j] > arr6[j+1]){
                    int temp = arr6[j];
                    arr6[j] = arr6[j+ 1];
                    arr6[j+1] = temp;

                    swap = 1;
                }
            }
            if(swap == 0)
                break;
        }
    }

    static void insertionSortP(int[] arr7){
        for (int i=0; i<= arr7.length-1;i++){
            int j=i;

            while (j > 0 && arr7[j-1] > arr7[j]){
                int temp = arr7[j-1];
                arr7[j-1] = arr7[j];
                arr7[j] = temp;
                j--;

            }
        }
    }
}
