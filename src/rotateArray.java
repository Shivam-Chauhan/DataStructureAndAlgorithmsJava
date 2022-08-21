public class rotateArray {
    // Time Complexity :- O(2*N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/rotate-array/
    public void rotater(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        rotater(nums, 0, n - k % n - 1);
        rotater(nums, n - k % n, n - 1);
        rotater(nums, 0, n - 1);
    }
}
