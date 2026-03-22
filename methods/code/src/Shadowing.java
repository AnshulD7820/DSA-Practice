public class Shadowing {
    static int x = 45; //
    public static void main(String[] args) {
        System.out.println(x); // 45
//        int x = 18;
        int x;
//        System.out.println(x); // scope will begin  when value is initialized
        x= 7;
        System.out.println(x);
        fun();
    }
    static void fun(){
        System.out.println(x);
    }
}
