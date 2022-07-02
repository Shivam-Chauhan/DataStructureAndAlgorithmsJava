public class MovingZeroes {
    public void printingOfArray(int[] nums1){
        for(int i:nums1){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void moverFunction(int[] nums){
        int index=0;
        for(int i:nums){
            if(i!=0){
                nums[index++]=i;
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }
        printingOfArray(nums);
    }

    public static void main(String[] args) {
        MovingZeroes obj= new MovingZeroes();
        int[] nums={0};
        obj.moverFunction(nums);
    }
}
