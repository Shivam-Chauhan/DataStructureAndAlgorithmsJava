import java.util.ArrayList;
import java.util.List;

public class subSets {

    public void subSetsFinder(int[] nums, int index, List<Integer> tempStore, List<List<Integer>> storage){
        if(index==nums.length){
            storage.add(new ArrayList<>(tempStore));
            return;
        }
        tempStore.add(nums[index]);
        subSetsFinder(nums,index+1,tempStore,storage);
        tempStore.remove(tempStore.size()-1);
        subSetsFinder(nums,index+1,tempStore,storage);
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subSets obj = new subSets();
        List<Integer> tempStore=new ArrayList<>();
        List<List<Integer>> storage= new ArrayList<>();
        obj.subSetsFinder(nums,0, tempStore,storage);
    }
}
