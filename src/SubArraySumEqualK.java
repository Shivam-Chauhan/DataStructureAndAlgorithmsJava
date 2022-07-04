import java.util.HashMap;

public class SubArraySumEqualK {
    public int subArraySumEqaulKFunction(int[] nums,int k){
        int[] prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        HashMap<Integer,Integer> mpp=new HashMap<Integer,Integer>();
        int counter=0;
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(prefixSum[i]==k) counter++;
            if(mpp.containsKey(prefixSum[i]-k)){
                counter+=mpp.get(prefixSum[i]-k);
            }
            mpp.putIfAbsent(prefixSum[i],0);
            mpp.put(prefixSum[i],mpp.get(prefixSum[i])+1);
        }
        return counter;
    }

}
