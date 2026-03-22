// Variable length argument:

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
//        fun(51,45,18,7,99,1,333);
        multiple(18, 45, "Virat", "Rohit", "Rahul");
    }
    static void multiple(int a , int b , String ...v){
    }

    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
