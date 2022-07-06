import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetsTwo {
    public void printing(List<List<Integer>> storage) {
        for (int i = 0; i < storage.size(); i++) {
            for (int j : storage.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public void subSetsTwoFinder(int[] nums,int index, List<Integer> tempStore,
                                 List<List<Integer>> storage, boolean[] freq){
        if(index==nums.length){
            storage.add(new ArrayList<>(tempStore));
            return;
        }
        if(!(index>0 && nums[index]==nums[index-1] && freq[index-1]==false)){
                freq[index]=true;
                tempStore.add(nums[index]);
                subSetsTwoFinder(nums,index+1,tempStore,storage,freq);
                tempStore.remove(tempStore.size()-1);
                freq[index]=false;
        }
        subSetsTwoFinder(nums,index+1,tempStore,storage,freq);
    }
    public static void main(String[] args) {
        int[] nums={1,2,2};
        subSetsTwo obj=new subSetsTwo();
        List<Integer> tempStore=new ArrayList<>();
        List<List<Integer>> storage=new ArrayList<>();
        Arrays.sort(nums);
        obj.subSetsTwoFinder(nums,0,tempStore,storage,new boolean[nums.length]);
        obj.printing(storage);
    }
}
