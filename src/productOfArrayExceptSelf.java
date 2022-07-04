public class productOfArrayExceptSelf {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int[] productOfArrayExceptSelfBetterSolution(int[] nums){
        int len=nums.length;
        int[] leftProduct=new int[len];
        int[] rightProduct=new int[len];
        int[] output=new int[len];
        int left=1,right=1;
        for(int i=0;i<len;i++){
            leftProduct[i]=nums[i]*left;
            rightProduct[len-i-1]=nums[len-i-1]*right;
            left*=nums[i];
            right*=nums[len-1-i];
        }

        for(int i=0;i<len;i++){
            if(i==0) output[i]=rightProduct[i+1];
            else if(i==len-1) output[i]=leftProduct[i-1];
            else output[i]=rightProduct[i+1]*leftProduct[i-1];
        }
        return output;
    }

    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int[] productOfArrayExceptSelfOptimalSolution(int[] nums){
        int len=nums.length;
        int[] output=new int[len];
        output[0]=1;
        for(int i=1;i<len;i++){
            output[i]=output[i-1]*nums[i-1];
        }
        int right=1;
        for(int j=len-1;j>=0;j--){
            output[j]=right*output[j];
            right*=nums[j];
        }
        return output;
    }
}
