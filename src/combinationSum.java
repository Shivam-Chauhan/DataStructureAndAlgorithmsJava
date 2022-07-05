import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public void printingArray(List<List<Integer>> storage){
        for(int i=0;i<storage.size();i++){
            for(int j: storage.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    // Time Complexity :- O(2^n)
    // Space Complexity :- Recursion Space of using Stack
    public void combinationSumFinder(int[] candidates,int target,List<List<Integer>> storage,
                                              List<Integer> randomStorage, int index){
        if(index==candidates.length){
            if(target==0){
                storage.add(new ArrayList<>(randomStorage));
            }
            return;
        }
        if(candidates[index]<=target){
            randomStorage.add(candidates[index]);
            combinationSumFinder(candidates,target-candidates[index], storage,randomStorage,index);
            randomStorage.remove(randomStorage.size()-1);
        }
        combinationSumFinder(candidates,target, storage,randomStorage,index+1);
    }
    public static void main(String[] args) {
        List<List<Integer>> storage=new ArrayList<>();
        List<Integer> randomStorage=new ArrayList<>();
        int[] candidates={2,3,6,7};
        int target=7;
        combinationSum obj=new combinationSum();
        obj.combinationSumFinder(candidates,target,storage,randomStorage,0);
        obj.printingArray(storage);

    }
}
