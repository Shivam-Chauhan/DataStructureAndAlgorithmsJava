import java.util.Arrays;

public class threeSumClosest {
    // Time Complexity :- O(N*Log(N))+O(N^2)
    // Space Complexity :- O(1)
    public int threeSumClosestFunction(int[] nums,int target){
        int diff=1000000,answer=0;
        Arrays.sort(nums);
        for(int first=0;first<nums.length-1;first++){
            int second=first+1,last=nums.length-1;
            while(second<last){
                int summation=nums[first]+nums[second]+nums[last];
                if(Math.abs(summation-target)<=diff){
                    diff=Math.abs(summation-target);
                    answer=summation;
                }
                if(summation>target) last--;
                else second++;
            }
        }
        return answer;
    }
}
