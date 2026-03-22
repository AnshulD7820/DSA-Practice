import java.util.Arrays;
import java.util.Scanner;

public class PracticeA_S {
    public static void main(String[] args) {

        //ARRAYS:
        // 1. Declaration and Initialization:
//        int[] arr = new int[5];    // Fixed Size
//        int[] arr2 = {18, 45, 7, 66};    // Direct initialization

        // 2. Traversing Array:
//        for(int i = 0; i < arr2.length; i++){
//            System.out.println(arr2[i]);
//        }
        // Enhanced for loop:
//        for(int num : arr2){
//            System.out.println(num);
//        }

        // 3. Taking input
//        Scanner input = new Scanner((System.in));
//        int num = input.nextInt();

//        int[] arr3 =  new int[num];

//        for(int i =0; i < num; i++){
//            arr3[i] = input.nextInt();
//        }

        // Reverse Array:
//        int[] arr5={18, 45, 99, 56};
//        int left = 0;
//        int right = arr5.length - 1;
//
//        while (left < right){
//            int temp = arr5[left];
//            arr5[left] = arr5[right];
//            arr5[right] = temp;
//
//            left ++;
//            right --;
//        System.out.println(Arrays.toString(arr5));
//        }

            // STRINGS:
        // 1. Declaration:
        String s1 = "Anshul";
        String s2 = "JAVA";

        // 2. Important String Methods:
        System.out.println(s1.length());  // 6
        System.out.println(s1.charAt(0));  // A
        System.out.println(s1.substring(0,4));  //Ansh
        System.out.println(s1.equals(s2));  //false
        System.out.println(s1.indexOf('A')); // 0
        System.out.println(s2.toLowerCase()); // java
        System.out.println(s1.toUpperCase());  // ANSHUL

        String s3 = "Hello";
        for (int i = 0; i < s3.length(); i++) {
            System.out.println(s3.charAt(i));
        }

        // 3. String to Char Array
        char[] arr6 = s1.toCharArray();
        System.out.println(arr6);

        // 4. StringBuilder
        // When to use :-
        // 1. Reverse string 2. Large concatenations 3. Palindrome problem
        StringBuilder sb = new StringBuilder();

        sb.append("Hello ");
        sb.append("World");
        System.out.println(sb.toString());


    }
}
