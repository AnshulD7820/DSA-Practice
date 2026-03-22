public class OverLoading {
    public static void main(String[] args) {
//        fun(18);
//        fun("Virat");
//        int ans = sum(18, 7, 45);
          int ans = sum(45, 18);
        System.out.println(ans);
    }
    static int sum(int a, int b){
        return a + b;
    }
    static int sum(int a , int b, int c){
        return a + b + c;
    }

    static void fun(int a){
        System.out.println(a);
    }
    static void fun(String name){
        System.out.println(name);
    }
}
