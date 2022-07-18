public class singleElementSortedArray {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1)
    public int singleElementFinder(int[] nums){
        int low=0,high=nums.length-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==nums[mid^1]) low=mid+1;
            else high=mid-1;
        }
        return nums[low];
    }
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4,8,8};
        singleElementSortedArray obj=new singleElementSortedArray();
        System.out.println(obj.singleElementFinder(nums));

    }
}
