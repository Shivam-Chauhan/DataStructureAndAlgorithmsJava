public class SqOfSortedArray {
    public void printingOfArray(int[] nums1){
        for(int i:nums1){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    // Time Complexity :- O(N)
    // Space Compexity :- O(1)
    public int[] sqOfSortedArrayFunction(int[] nums){
        int[] storage=new int[nums.length];
        int leftPointer=0,rightPointer=nums.length-1,index=nums.length-1;
        while(leftPointer<=rightPointer){
            int rightElement= (int) Math.pow(nums[rightPointer],2);
            int leftElement= (int) Math.pow(nums[leftPointer],2);
            if(rightElement>leftElement){
                storage[index--]=rightElement;
                rightPointer--;
            }
            else{
                storage[index--]=leftElement;
                leftPointer++;
            }
        }
        printingOfArray(storage);
        return storage;
    }

    public static void main(String[] args) {
        SqOfSortedArray obj = new SqOfSortedArray();
        int[] nums={-7,-3,2,3,11};
        obj.sqOfSortedArrayFunction(nums);
    }
}
