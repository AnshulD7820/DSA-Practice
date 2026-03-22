import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Number Hashing:
//        int n;
//        n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++){
//            arr[i] = in.nextInt();
//        }
//        //precompute:
//        int[] hash = new int[13];
//        for (int i = 0; i < n; i++){
//            hash[arr[i]] += 1;
//        }
//        int q;
//        q = in.nextInt();
//        while (q-- != 0){
//            int number ;
//            number = in.nextInt();
//        fetching:
//            System.out.println(hash[number]);
//        }

        // Character Hashing:
        // Code if the string contains only lowercase:
//        String s;
//        s = in.next();
//        //Precompute:
//        int[] hash1 = new int[26];
//        for (int i =0; i < s.length(); i++){
//            hash1[s.charAt(i) - 'a']++;
//        }
//        int q1;
//        q1 = in.nextInt();
//        while (q1-- > 0){
//            char c;
//            c = in.next().charAt(0);
//            //Fetch:
//            System.out.println(hash1[c - 'a']);
//        }

        // Code if the string contains both uppercase and lowercase:
//        String s;
//        s = in.next();
//        //precompute:
//        int[] hash = new int[256];
//        for (int i=0; i< s.length(); i++){
//            hash[s.charAt(i)]++;
//        }
//        int q;
//        q= in.nextInt();
//        while (q-- > 0){
//            char c;
//            c = in.next().charAt(0);
//            //fetch:
//            System.out.println(hash[c]);
//        }

        //  Hashmap(Array Hashing):
//        int n;
//        n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i =0; i<n;i++){
//            arr[i] = in.nextInt();
//        }
//        //precompute:
//        HashMap<Integer, Integer>  map = new HashMap<>();
//        for (int i=0;i<n;i++){
//            int key = arr[i];
//            int freq = 0;
//            if(map.containsKey(key)) freq = map.get(key);
//            freq ++;
//            map.put(key, freq);
//        }
//        int q ;
//        q = in.nextInt();
//        while (q-- > 0){
//            int number;
//            number = in.nextInt();
//            //fetch:
//            if(map.containsKey(number))
//                System.out.println(map.get(number));
//            else System.out.println(0);
//        }

        // Hashmap(Character Hashing):
//        String s;
//        s = in.next();
//
//        // precompute:
//        HashMap<Character, Integer> map = new HashMap<>(256);
//        for (int i=0;i<s.length();i++){
//            char key = s.charAt(i);
//            int freq = 0;
//            if(map.containsKey(key)) freq = map.get(key);
//            freq ++;
//            map.put(key, freq);
//        }
//        int q;
//        q = in.nextInt();
//        while (q-- > 0){
//            char c ;
//            c = in.next().charAt(0);
//            //fetch:
//            if(map.containsKey(c))
//                System.out.println(map.get(c));
//            else System.out.println(0);
//        }

        // Practice Problem 1: Count frequency of each element in the array
//        int[] arr = {1, 2, 2, 3, 3, 5};
//        System.out.println(countFreq(arr));

        // Practice:
//        int[] array ={1,8,5,1,6,1,2};
//        HashMap<Integer, Integer> sample = new HashMap<>();
//        for (int num : array){
//            sample.put(num, sample.getOrDefault(num, 0) + 1);
//        }
//        System.out.println(sample);

        int[] arr = {1, 2, 3, 1, 1, 4};
        System.out.println(Arrays.toString(mostFreqEle(arr)));

    }

    // Practice Problem 1: Count frequency of each element in the array
    static ArrayList<ArrayList<Integer>> countFreq(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ArrayList<Integer> pair = new ArrayList<>();

            pair.add(entry.getKey());
            pair.add(entry.getValue());

            result.add(pair);
        }
        return result;
    }

    public static int[] mostFreqEle(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        int maxEle =0;
        int minFreq =n;
        int minEle = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxFreq || (entry.getValue() == maxFreq && entry.getKey() < maxEle)){
            maxFreq = entry.getValue();
            maxEle = entry.getKey();
            }
            if(entry.getValue() < minFreq || (entry.getValue() == minFreq && entry.getKey() < minEle)){
                minFreq = entry.getValue();
                minEle = entry.getKey();
            }
        }
      return new int[]{maxEle,minEle};
    }

}
