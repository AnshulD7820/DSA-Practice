//  GFG Problem : Allocate Minimum Pages
//  Link : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

public class Allocate_Minimum_Number_Of_Pages {
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;

        System.out.println("Brute Force Approach : " + allocateMinNumPageBrute(books,students));
        System.out.println("Optimal Approach : " + allocateMinNumPageOptimal(books,students));

    }

//    Brute Force Approach :
    public static int allocateMinNumPageBrute(int[] books, int students){
        if(students > books.length){
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int num : books){
            low = Math.max(low, num);   // Low = max element in an array
            high += num;                // high = sum of elements in an array
        }

        for (int i = low ; i <= high ; i ++){
            int requiredStudents = countStudents(books,i);

            if(requiredStudents == students){
                return i;
            }
        }
        return low;
    }
    public static int countStudents(int[] books, int pages){
        int students = 1;
        int currentPages = 0;

        for (int num : books){
            if(currentPages + num <= pages){
                currentPages += num;
            }
            else{
                students ++;
                currentPages = num;
            }
        }
        return students;
    }

//    Time Complexity : O((sum-max) × n)
//    Space Complexity : O(1)

//    Optimal Approach :  Binary Search on Answers
    public static int allocateMinNumPageOptimal(int[] books, int students){
        if(students > books.length){
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int num : books){
            low = Math.max(low, num);
            high += num;
        }

        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int requiredStudents = countStudents(books, mid);

            if(requiredStudents <= students){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

//    Time Complexity : O(n × log S)
//                          Where : O(n) - Helper function that we used to calculate the number of students
//                                  O(log S) - Binary Search
//                                                Where S is the sum of pages : sum(books[]) - max(books[]) + 1
//    Space Complexity : O(1)

}
