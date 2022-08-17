public class maxConsecutiveOnes {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/max-consecutive-ones/submissions/
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0, maxi = 0;
        for (int element : nums) {
            if (element == 1) counter++;
            else {
                maxi = Math.max(maxi, counter);
                counter = 0;
            }
        }
        maxi = Math.max(maxi, counter);
        return maxi;
    }
}
