public class RunningSum {
    public void printingOfArray(int[] nums1){
        for(int i:nums1){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    // Time complexity :- O(N)
    // Space complexity :- O(1)
    public void runningSumFunction(int[] nums){
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
    }
}
