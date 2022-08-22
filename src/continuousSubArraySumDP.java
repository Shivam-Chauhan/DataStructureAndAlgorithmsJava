import java.util.HashMap;

public class continuousSubArraySumDP {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/continuous-subarray-sum/
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // Remainder and starting index
        hashMap.put(0, -1);
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            int remainder = totalSum % k;
            if (!hashMap.containsKey(remainder)) hashMap.put(remainder, i);
            else if (i - hashMap.get(remainder) > 1) return true;
        }
        return false;
    }
}
