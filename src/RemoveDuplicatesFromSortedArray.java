public class RemoveDuplicatesFromSortedArray {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int removeDuplicateFromSortedArrayFunction(int[] nums){
        if(nums.length<2) return nums.length;
        int index=1;
            for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) nums[index++]=nums[i];
        }
            return index;
    }
}
