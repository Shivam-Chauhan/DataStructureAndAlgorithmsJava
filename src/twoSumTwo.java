public class twoSumTwo {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int tempTarget = numbers[left] + numbers[right];
            if (tempTarget == target) {
                return new int[]{left + 1, right + 1};
            } else if (tempTarget > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0, 0};
    }
}
