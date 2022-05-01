import java.util.HashMap;

public class largestSubArrayWithZeroSum {
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(N)
    public int largestSubArrayWithZeroSumUtil(int[] arr){
        HashMap<Integer,Integer> storage=new HashMap<>();
        int currSum=0,maxLength=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum==0) maxLength=i+1;
            else{
                if(storage.containsKey(currSum)==true)  maxLength=Math.max(maxLength,i-storage.get(currSum));
                else storage.put(currSum,i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr={1,-1,3,2,-2,-8,1,7,10,23};
        largestSubArrayWithZeroSum obj=new largestSubArrayWithZeroSum();
        System.out.println(obj.largestSubArrayWithZeroSumUtil(arr));
    }
}
