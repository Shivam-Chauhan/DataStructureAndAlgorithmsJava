public class firstAndLastPosInSortedArray {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1)
    public int lastPosition(int[] nums, int target){
        int index=-1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;
            }
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return index;
    }
    public int firstPosition(int[] nums, int target){
        int index=-1,low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;
            }
            else if(nums[mid]>=target) high=mid-1;
            else low=mid+1;
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstPosition(nums,target),lastPosition(nums,target)};
    }
}
