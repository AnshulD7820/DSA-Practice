import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Practice {
    public static void main(String[] args) {

        // Basic Hashing Example:
        int[] arr = {1,3,2,1,3,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
//        System.out.println(map);
//        System.out.println(map.get(1));

        // Number Hashing:
        int[] arr2 = {1,3,2,1,3};
        int[] hash = new int[4];   // Because max element = 3

        for (int num : arr2) {
            hash[num]++;
        }
//        System.out.println(hash[1]);  // Frequency of 1  = 2
//        System.out.println(hash[2]);  // Frequency of 2 = 1
//        System.out.println(hash[3]);  // Frequency of 3 = 2

        // Character Hashing:
        // A. If String Contains Only LowerCase:

        String s = "abcaab";
        int[] hash2 = new int[26];

        for (int i =0;i<s.length();i++){
           hash2[s.charAt(i) - 'a']++;
        }
//        System.out.println(Arrays.toString(hash2));
//        System.out.println(hash2['a' - 'a']);   // Here we have done (Character - 'a')
//        System.out.println(hash2['b' - 'a']);
//        System.out.println(hash2['c' - 'a']);

        // B. If String Contains Only UpperCase:
        String s2 = "ABCDACSS";

        int[] hash3 = new int[26];

        for (int i=0;i<s2.length();i++){
            hash3[s2.charAt(i) - 'A']++;
        }
//        System.out.println(hash3['A' - 'A']);
//        System.out.println(hash3['B' - 'A']);
//        System.out.println(hash3['C' - 'A']);
//        System.out.println(hash3['D' - 'A']);
//        System.out.println(hash3['S' - 'A']);

        // If String Contains Both UpperCase And LowerCase:
        String s3 = "aAbBcC";
        int[] hash4 = new int[256];

        for (int i =0; i< s3.length();i++){
            hash4[s3.charAt(i)]++;
        }
//        System.out.println(hash4['a']);
//        System.out.println(hash4['A']);
//        System.out.println(hash4['b']);
//        System.out.println(hash4['C']);

        // Character HashMap:
        String s4 = "abcAac";
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i=0;i<s4.length();i++){
            char ch = s4.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0) + 1);
        }
//        System.out.println(map2);

        // HashSet Example : Check if duplicates exits.

        int[] arr5 = {1,1,1,3,3,4,3,2,4,2};
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr5){
            if(set.contains(num)){
                System.out.println("Duplicate Found: " + num);
                return;
            }
            set.add(num);
        }
        System.out.println("No Duplicates Found");
    }

}
