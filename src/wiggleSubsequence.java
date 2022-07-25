public class wiggleSubsequence {
    // Time Complexity for inserting :- O(N)
    // Space Complexity for Finding  :- O(1)
    public int wiggleMaxLength(int[] nums) {
        int peak=1,valley=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) peak=valley+1;
            else if(nums[i]<nums[i-1]) valley=peak+1;
        }
        return Math.max(peak, valley);
    }
}
