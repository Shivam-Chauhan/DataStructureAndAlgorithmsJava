public class duplicateElement {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int duplicateElementFinder(int[] nums){
        for(int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i]);
            if(nums[temp-1]<0) return temp;
            nums[temp-1]*=-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        duplicateElement obj=new duplicateElement();
        System.out.println(obj.duplicateElementFinder(nums));
    }
}
