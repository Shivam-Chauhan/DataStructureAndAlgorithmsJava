import java.util.ArrayList;

public class maxSumWindowSizeK {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // link :- https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
    static long maximumSumSubarray(int K, ArrayList<Integer> array, int N) {
        int left = 0, right = 0;
        long summation = 0, maxi = 0;
        while (right < array.size()) {
            summation += array.get(right);
            maxi = Math.max(summation, maxi);
            if (right - left + 1 < K) {
                right++;
            } else if (right - left + 1 == K) {
                summation -= array.get(left);
                left++;
                right++;
            }
        }
        maxi = Math.max(summation, maxi);
        return maxi;
    }
}
