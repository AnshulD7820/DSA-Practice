// Write a program to check the number of occurrence in a  series of number

import java.util.Scanner;

public class CountNumber {
    public static void main(String[] args) {
       int num = 782079634;
       int count = 0;

       while (num > 0){
           int rem = num % 10;
           if(rem == 7){
               count++;
           }
           num = num / 10;
       }
        System.out.println(count);

    }
}
