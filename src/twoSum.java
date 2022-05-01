import java.util.HashMap;
public class twoSum {
    public int[] twoSumUtil(int[] nums,int target){
        HashMap<Integer,Integer>storage=new HashMap<>();
        int[] output=new int[2];
        for(int i=0;i<nums.length;i++){
            if(storage.containsKey(target-nums[i])){
                output[0]=storage.get(target-nums[i]);
                output[1]=i;
                return output;
            }
            storage.put(nums[i],i);
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] output=new int[2];
        twoSum obj=new twoSum();
        output=obj.twoSumUtil(nums,target);
        for(int i:output) System.out.print(i+ " ");
    }
}
