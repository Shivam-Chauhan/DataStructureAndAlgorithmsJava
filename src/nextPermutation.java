public class nextPermutation {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/next-permutation/submissions/
    public void swapper(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void reverser(int[] nums, int left, int right) {
        while (left < right) {
            swapper(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int arrayLength = nums.length;
        int index = arrayLength - 2, index2 = arrayLength - 1;
        while (index >= 0 && nums[index] >= nums[index + 1]) index--;
        if (index < 0) reverser(nums, index + 1, arrayLength - 1);
        else {
            while (index2 > index && nums[index2] <= nums[index]) index2--;
            swapper(nums, index, index2);
            reverser(nums, index + 1, arrayLength - 1);
        }
    }
}
