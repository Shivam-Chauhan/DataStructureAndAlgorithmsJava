import java.util.ArrayList;
import java.util.List;

public class allDuplicatesElement {
    public void printingList(List<Integer> result){
        for(int i:result) System.out.print(i+ " ");
        System.out.println();
    }

    public List<Integer> allDuplicatesElementFinder(int[] nums){
        List<Integer> storage=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp=Math.abs(nums[i]);
            if(nums[temp-1]<0) storage.add(temp);
            nums[temp-1]*=-1;
        }
        return storage;
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        allDuplicatesElement obj=new allDuplicatesElement();
        List<Integer> output=obj.allDuplicatesElementFinder(nums);
        obj.printingList(output);


    }
}
