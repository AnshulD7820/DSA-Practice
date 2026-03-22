import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        pattern1(5);
//        pattern2(5);
//        pattern3(4);
//        pattern4(5);
//        pattern5(6);
//        pattern6(6);
//        pattern7(5);
//        pattern8(5);
//        pattern9(5);
//        pattern10(5);
//        pattern11(5);
//        pattern12(5);
//        pattern13(5);
//        pattern14(5);
//        pattern15(5);
//        pattern16(5);
//        pattern17(5);
//        pattern18(5);
//        pattern19(3);
//        pattern20(3);
//        pattern21(3);
//        pattern22(5);
    }

//    static void pattern1(int n){
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern2(int n){
//        for (int i = 0; i < n; i++) {
//            for(int j = 0; j<= i; j ++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern3(int n){
//        for (int i = 1; i<= n; i++ ){
//            for(int j = 1; j<= i; j++ ){
//                System.out.print(j + " " );
//            }
//            System.out.println();
//        }
//    }
//    static void pattern4(int n){
//        for (int i = 1; i<= n; i++){
//            for(int j = 1 ; j<=i; j ++){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern5(int n){
//        for (int i = 1; i <= n; i++){
//            for(int j = 1; j< n-i+1; j ++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern6(int n){
//        for(int i = 1; i<= n; i ++){
//            for (int j = 1; j < n-i+1; j++){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern7(int n){
//       for (int i = 0; i < n; i++){
//           //Space
//           for(int j =0; j< n-i-1; j++){
//               System.out.print(" ");
//           }
//           //Star
//           for(int j=0; j<2*i+1;j++){
//               System.out.print("*");
//           }
//           //Space
//           for (int j=0; j< n-i-1; j++){
//               System.out.print(" ");
//           }
//        System.out.println();
//       }
//    }
//    static void pattern8(int n){
//        for(int i = 0; i < n; i ++){
//            //Space
//            for (int j = 0; j < i ; j++){
//                System.out.print(" ");
//            }
//            //Star
//            for (int j =0; j < 2*n-(2*i+1); j++){
//                System.out.print("*");
//            }
//            //Space
//            for (int j=0; j<i;j++){
//                System.out.print(" ");
//            }
//        System.out.println();
//        }
//    }
//        static void pattern9(int n){
//        for (int i = 0; i < n; i++) {
//            //Upper pyramid
//            //Space
//            for (int j = 0; j < n - i - 1; j++) {
//                System.out.print(" ");
//            }
//            //Star
//            for (int j = 0; j < 2 * i + 1; j++) {
//                System.out.print("*");
//            }
//            //Space
//            for (int j = 0; j < n - i - 1; j++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//            //Lower inverted pyramid
//            for(int i=0; i<n; i++){
//            //Space
//            for (int j =0; j<i;j++){
//                System.out.print(" ");
//            }
//            //Star
//            for (int j=0; j< 2*n-(2*i+1);j++){
//                System.out.print("*");
//            }
//            //Space
//            for (int j =0; j<i;j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//            }
//        }
//    static void pattern10(int n){
//        for (int i=1; i<=2*n-1; i++){
//            int stars = i;
//            if(i>n) {
//                stars=2*n-i;
//            };
//            for (int j=1; j<=stars; j++){
//                System.out.print("*");
//            }
//        System.out.println();
//        }
//    }
//    static void pattern11(int n){
//        int start =1;
//        for(int i =0;i<n;i++ ){
//            if(i % 2 == 0){
//                start = 1;
//            }else {
//                start = 0;
//            }
//            for (int j =0; j<= i; j++){
//                System.out.print(start);
//                start =1-start ;
//            }
//            System.out.println();
//        }
//    }
//    static void pattern12(int n){
//        int space= 2*(n-1);
//        for (int i =1; i<=n;i++ ){
//            //Number
//                for (int j=1; j<=i;j++){
//                    System.out.print(j);
//                }
//            //Space
//            for (int j=1; j<= space;j++){
//                System.out.print(" ");
//            }
//            //Number
//            for (int j=i; j>=1;j--){
//                System.out.print(j);
//            }
//            System.out.println();
//            space -= 2;
//        }
//    }
//    static void pattern13(int n){
//        int num =1;
//       for (int i=1; i<=n;i++){
//           for (int j=1; j<=i;j++){
//               System.out.print(num + " ");
//               num = num + 1;
//           }
//           System.out.println();
//
//       }
//    }
//    static void pattern14(int n){
//        for (int i=0; i<n; i++){
//            for (char ch='A'; ch <= 'A' + i; ch ++){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern15(int n){
//        for (int i=0; i<n;i++){
//            for( char ch ='A'; ch<= 'A'+(n-i-1);ch++){
//                System.out.print(ch+ " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern16(int n){
//        for (int i=0;i<n;i++){
//            char ch= (char) ('A'+ i);
//            for (int j=0;j<=i;j++){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern17(int n){
//        for (int i=0;i<n;i++){
//            //Space
//            for (int j=0; j<n-i-1;j++){
//                System.out.print(" ");
//            }
//            //Character
//            char chr = 'A';
//            int breakpoint = (2*i+1)/2;
//            for (int j=1; j<=2*i+1;j++){
//                System.out.print(chr);
//                if (j<= breakpoint) chr++;
//                else chr--;
//            }
//            //Space
//            for (int j=0; j<n-i-1;j++){
//                System.out.print(" ");
//            }
//        System.out.println();
//
//        }
//    }
//    static void pattern18(int n){
//        for (int i=0; i<n;i++){
//            for (char ch = (char)('E'- i); ch<='E'; ch++){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void pattern19(int n){
//            int inSpa = 0;
//        for (int i=0; i<n; i++){
//            //Stars
//            for (int j=1; j<=n-i; j++){
//                System.out.print("*");
//            }
//            //Space
//            for (int j=0;j<inSpa;j++){
//                System.out.print(" ");
//            }
//            //Stars
//            for (int j=1; j<=n-i;j++){
//                System.out.print("*");
//            }
//            inSpa += 2;
//            System.out.println();
//        }
//        inSpa=2*n-2;
//        for (int i=1; i<=n;i++){
//            //Stars
//            for (int j=1; j<=i; j++){
//                System.out.print("*");
//            }
//            //Space
//            for (int j=0; j<inSpa;j++){
//                System.out.print(" ");
//            }
//            //Stars
//            for (int j=1; j<=i; j++){
//                System.out.print("*");
//            }
//            inSpa -= 2;
//            System.out.println();
//        }
//    }
//    static void pattern20(int n){
//        int spaces= 2*n-2;
//        for (int i=1; i<=2*n-1;i++){
//            int stars =i;
//            if(i > n) stars=2* n-i;
//            //stars
//            for (int j=1; j<=stars;j++){
//                System.out.print("*");
//            }
//            //space
//            for (int j=1;j<=spaces;j++ ){
//                System.out.print(" ");
//            }
//            //stars
//            for (int j=1; j<= stars; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//            if(i < n) spaces -= 2;
//            else spaces +=2;
//        }
//    }
//    static void pattern21(int n){
//        for(int i=0; i<n;i++){
//            for (int j=0;j<n;j++ ){
//                if(i == 0 || j == 0 || i == n-1 || j == n-1){
//                    System.out.print("*");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
//    static void pattern22(int n){
//        for (int i=0; i< 2*n-1;i++){
//            for (int j=0; j<2*n-1;j++){
//                int top = i;
//                int left = j;
//                int bottom = (2*n-2)-i;
//                int right = (2*n-2)-j;
//
//                int minDis = Math.min(Math.min(top, bottom), Math.min(left, right));
//                System.out.print((n- minDis) + " ");
//            }
//            System.out.println();
//        }
//    }
}
