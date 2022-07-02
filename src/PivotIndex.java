import java.util.ArrayList;
import java.util.List;

public class PivotIndex {
    public void printingOfArray(int[] nums1){
        for(int i:nums1){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public int pivotIndexFunction(int[] nums){
        int leftSum=0, rightSum=0;
        for(int i:nums){
            rightSum+=i;
        }
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if(rightSum==leftSum)return i;
            leftSum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={2,-1,1};
        PivotIndex obj = new PivotIndex();
        System.out.println(obj.pivotIndexFunction(nums));
    }
}
