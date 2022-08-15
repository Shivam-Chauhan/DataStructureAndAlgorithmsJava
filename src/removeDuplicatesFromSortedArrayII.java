public class removeDuplicatesFromSortedArrayII {
    // Time Complexity:- O(N)
    // Space Complexity :- O(1)
    public int removeDuplicates(int[] nums) {
        int prev = 1, curr = 2;
        while (curr < nums.length) {
            if (nums[prev] == nums[curr] && nums[prev - 1] == nums[curr]) {
                curr++;
            } else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }
        }
        return prev + 1;
    }
}
