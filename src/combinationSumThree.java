import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumThree {
    public void printingArray(List<List<Integer>> storage){
        for(int i=0;i<storage.size();i++){
            for(int j: storage.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    // Time Complexity :- O(2^n)
    // Space Complexity :- O(N) + Recursion Space of using Stack
    public void combinationSumFinder(int[] candidates,int target,List<List<Integer>> storage,
                                     List<Integer> randomStorage, int index, boolean[] freq, int k){
        if(index==candidates.length){
            if(target==0 && randomStorage.size()==k){
                storage.add(new ArrayList<>(randomStorage));
            }
            return;
        }
        if(candidates[index]<=target){
            if(!(index>0 && candidates[index]==candidates[index-1] && freq[index-1]==false)){
                randomStorage.add(candidates[index]);
                freq[index]=true;
                combinationSumFinder(candidates,target-candidates[index], storage,randomStorage,
                        index+1,freq, k);
                randomStorage.remove(randomStorage.size()-1);
                freq[index]=false;
            }
        }
        combinationSumFinder(candidates,target, storage,randomStorage,index+1,freq,k);
    }
    public static void main(String[] args) {
        List<List<Integer>> storage=new ArrayList<>();
        List<Integer> randomStorage=new ArrayList<>();
        int n=1, k=4;
        int[] candidates={1,2,3,4,5,6,7,8,9};
        combinationSumThree obj=new combinationSumThree();
        obj.combinationSumFinder(candidates,n,storage,randomStorage,0, new boolean[candidates.length],k);
        obj.printingArray(storage);

    }
}
