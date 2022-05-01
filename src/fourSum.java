import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    // Time Complexity:- O(N*log(N)) + O(N^3)
    // Space Complexity :- O(1)
    public List<List<Integer>> fourSumUtil(int[] nums, int target){
        List<List<Integer>> storage=new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)return storage;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int target2=target-nums[i]-nums[j];
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int tempTarget=nums[left]+nums[right];
                    if(tempTarget<target2) left++;
                    else if(tempTarget>target2) right--;
                    else{
                        List<Integer> quadStore=new ArrayList<>();
                        quadStore.add(nums[i]);
                        quadStore.add(nums[j]);
                        quadStore.add(nums[left]);
                        quadStore.add(nums[right]);
                        System.out.println(quadStore);
                        storage.add(quadStore);

                        // Processing the functionality of hashset from the right side...
                        while(left<right && nums[left]==quadStore.get(2)) left++;
                        // Processing the functionality of hashset from the right side of the array...
                        while(right>left && nums[right]==quadStore.get(3)) right--;
                    }
                }
                while(j+1<nums.length && nums[j+1]==nums[j]) j++;
            }
            while(i+1<nums.length && nums[i+1]==nums[i]) i++;
        }
        return storage;
    }
    public static void main(String[] args) {
        int[] nums ={2,2,2,2,2};
        int target=8;
        fourSum obj=new fourSum();
        List<List<Integer>> storage=obj.fourSumUtil(nums,target);
        for(List<Integer> temp:storage){
            System.out.println(temp);
        }
    }
}
