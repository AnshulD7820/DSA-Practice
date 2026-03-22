import java.util.*;

public class Main {
    static void main(String[] args) {

        //1.Arraylist:
        // Syntax:
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

//        System.out.println(list);
//        System.out.println(list.get(0));  .get is used to get the element
//        System.out.println(list.set(0,20)); .set is used to update the element
//        System.out.println(list.remove(1)); .remove is used to remove an element by index
//        System.out.println(list.size());  .size is used to get the size of an array
//        System.out.println(list.contains(20));  .contains is used to check whether the element in an array exists or not
                                                    // it prints the element in boolean (i.e. true or false)

        // 2.LinkedList:
        // Syntax:
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);

//        System.out.println(list2);

        //The Collections Utility Class:
        List<Integer> nums = Arrays.asList(3, 1, 4, 2);
        Collections.sort(nums);
        Collections.reverse(nums);
//        System.out.println(nums);

        // 3. Stack: LIFO (Last In First Out)
        // Syntax:
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
//        System.out.println(stack);
//        System.out.println(stack.push(50));  //.push is used to insert an element
//        System.out.println(stack.pop());  // .pop is used to remove the top element(means the last element)
//        System.out.println(stack.peek());  // .peek is used to see the top element (means the last element)
//        System.out.println(stack.isEmpty()); // isEmpty is used to check whether the array is empty or not(true or false)

        // 4. Queue: FIFO(First In First Out)
        // Syntax:
        Queue<Integer> q = new LinkedList<>();

        q.add(18);
        q.add(45);
        q.add(1);
        q.add(99);

//        System.out.println(q);
//        System.out.println(q.add(333));  // .add is used to insert an element
//        System.out.println(q.poll());  // .poll is used to remove a first element
//        System.out.println(q.peek());  //.peek id used to see the first element
//        System.out.println(q.isEmpty()); //.isEmpty is used to check whether the array is empty or not(true or false)

        // 5. HashSet: -> order is not maintained
        // Syntax:

        HashSet<Integer> set = new HashSet<>();
        set.add(7);
        set.add(18);
        set.add(45);
        set.add(1);
//        System.out.println(set);

        // 6. HashMap:  -> Stores key value pairs
        // Syntax:

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,100);
        map.put(1,200);

//        System.out.println(map.get(1));  //200
//        System.out.println(map.containsKey(0));  //true

        //  Example: Frequency Count

        int[] arr ={1,2,1,3};

        HashMap<Integer,Integer> map1 = new HashMap<>();

        for (int num : arr){
                map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
//        System.out.println(map1);

        // 7. PriorityQueue (Heap):
        // Syntax:

        // Default: Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
//        System.out.println(pq);

        // Max Heap

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(10);
        pq1.add(20);
        pq1.add(30);
        pq1.add(40);
//        System.out.println(pq1);

        int[] num = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(num, 9)));

    }
        // EXAMPLE: HashMap
//        Problem: Two Sum
//        Given array and target, return indices of two numbers whose sum = target.
//        Example:
//        Input:  num = [2,7,11,15]
//        Target: 9
//        Output: [0,1]
        public static  int[] twoSum(int[]nums, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int complement = target - nums[i];

            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
