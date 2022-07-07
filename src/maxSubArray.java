public class maxSubArray {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int kadaneAlgo(int[] nums){
        int maxSumSoFar=Integer.MIN_VALUE, maxSumAtThisPoint=0;
        for(int i:nums){
            maxSumAtThisPoint=Math.max(maxSumAtThisPoint+i,i);
            maxSumSoFar=Math.max(maxSumAtThisPoint,maxSumSoFar);
        }
        return maxSumSoFar;
    }
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray obj=new maxSubArray();
        System.out.println(obj.kadaneAlgo(nums));
    }
}
