public class maxProductSubArray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        int maxVal=nums[0],minVal=nums[0], ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxVal;
                maxVal=minVal;
                minVal=temp;
            }
            maxVal=Math.max(maxVal*nums[i],nums[i]);
            minVal=Math.min(minVal*nums[i],nums[i]);
            ans=Math.max(maxVal,ans);
        }
        System.out.println(ans);
    }
}
