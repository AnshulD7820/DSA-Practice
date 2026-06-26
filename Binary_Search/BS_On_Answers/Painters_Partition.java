//  GFG Problem : The Painter's Partition Problem-II
//  Link : https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1

//  Painter's Partition = Book Allocation = Split Array Largest Sum
//  This three problem are exactly same, only the story changes (code and logic are same)

public class Painters_Partition {
    public static void main(String[] args) {
        int[] boards = {5, 10, 30, 20, 15};
        int painters = 3;

        System.out.println("Painter's Partition : " + painterPartition(boards, painters));
    }

//    Optimal Binary Search Approach :
    public static int painterPartition(int[] boards, int painters){
        int low = 0;
        int high = 0;

        for (int num : boards){
            low = Math.max(low, num);
            high += num;
        }

        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int requiredPainters = countPainters(boards, mid);

            if(requiredPainters <= painters){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countPainters(int[] boards, int maxTime){
        int painters = 1;
        int currentTime = 0;

        for (int num : boards){
            if(currentTime + num <= maxTime){
                currentTime += num;
            }
            else{
                painters ++;
                currentTime = num;
            }
        }
        return painters;
    }
//    Time Complexity : O(n × log S)
//                          Where : O(n) - Helper function that we used to calculate the number of students
//                                  O(log S) - Binary Search
//                                                Where S is the sum of pages : sum(books[]) - max(books[]) + 1
//    Space Complexity : O(1)
}
