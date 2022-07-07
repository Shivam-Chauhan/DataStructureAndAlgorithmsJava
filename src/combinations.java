import java.util.ArrayList;
import java.util.List;

public class combinations {
    public void printing(List<List<Integer>> storage){
        for(int i=0;i<storage.size();i++){
            for(int j:storage.get(i)){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    // Time Complexity :- O(2^n)
    // Space Complexity :- O(N) + Auxillary Space of Recursion Stack
    public void combinationsFinder(int[] array,int k, int index, List<Integer> tempStore,List<List<Integer>> storage){
        if(index==array.length){
            if(tempStore.size()==k){
                storage.add(new ArrayList<>(tempStore));
            }
            return;
        }
        tempStore.add(array[index]);
        combinationsFinder(array,k,index+1,tempStore,storage);
        tempStore.remove(tempStore.size()-1);
        combinationsFinder(array,k,index+1,tempStore,storage);
    }
    public static void main(String[] args) {
        int n=4, k=2;
        int[] array=new int[n];
        for(int i=1;i<=n;i++){
            array[i-1]=i;
        }
        List<List<Integer>> storage=new ArrayList<>();
        List<Integer> tempStore=new ArrayList<>();
        combinations obj=new combinations();
        obj.combinationsFinder(array,k,0,tempStore,storage);
        obj.printing(storage);
    }
}
