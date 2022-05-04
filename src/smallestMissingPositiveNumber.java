import java.util.Arrays;

public class smallestMissingPositiveNumber {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int smallestMissingPositiveNumberUtil(int[] nums){
        for(int i=0;i<nums.length;i++){
            int currPosition=nums[i]-1;
            while(nums[i]>=1 && nums[i]<nums.length && nums[i]!=nums[currPosition]){
                int temp=nums[currPosition];
                nums[currPosition]=nums[i];
                nums[i]=temp;
                currPosition=nums[i]-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]) return i+1;
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        smallestMissingPositiveNumber obj=new smallestMissingPositiveNumber();
        System.out.println(obj.smallestMissingPositiveNumberUtil(nums));
    }
}
