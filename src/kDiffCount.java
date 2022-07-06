import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class kDiffCount {
    // Time Complexity :- O(N*Log(N)) +O(N)
    // Space Complexity :- O(N)
    public int kDiffCountFinderHashSet(int[] nums,int k){
        HashSet<Integer> hashSet=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(Arrays.binarySearch(nums,i+1,nums.length,nums[i]+k)>0) hashSet.add(nums[i]);
        }
        return hashSet.size();
    }
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int kDiffCountFinderHashMap(int[] nums,int k){
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i:nums){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        int result=0;
        for(int i:mpp.keySet()){
            if((k>0 && mpp.containsKey(i+k)==true) || (k==0 && mpp.get(i)>1)) result++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={3,1,4,1,5};
        int k=2;
        kDiffCount obj=new kDiffCount();
        System.out.println(obj.kDiffCountFinderHashMap(nums,k));
        System.out.println(obj.kDiffCountFinderHashSet(nums,k));
    }
}
