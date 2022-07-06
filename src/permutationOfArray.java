import java.util.ArrayList;
import java.util.List;

public class permutationOfArray {
    public void printing(List<List<Integer>> storage){
        for(int i=0;i<storage.size();i++){
            for(int j:storage.get(i)){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    // Time Complexity :- O(N!) + O(N)
    // Space Complexity :- O(N) + O(N) + Recursion Stack
    public void permutationMaker(int[] nums, List<Integer> tempStorage,
                                 List<List<Integer>> storage, int[] freq){
        if(tempStorage.size()==nums.length){
            storage.add(new ArrayList<>(tempStorage));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(freq[i]==0){
                freq[i]=1;
                tempStorage.add(nums[i]);
                permutationMaker(nums,tempStorage,storage,freq);
                freq[i]=0;
                tempStorage.remove(tempStorage.size()-1);
            }
        }
    }
    public void swapper(int index, int randomIndex, int[] nums){
        int temp=nums[randomIndex];
        nums[randomIndex]=nums[index];
        nums[index]=temp;
    }
    // Time Complexity :- O(N!) + O(N)
    // Space Complexity :- O(1) + Recursion Stack
    public void permutationMakerWithoutSpace(int[] nums,
                                  List<List<Integer>> storage, int index){
        if(index==nums.length){
            ArrayList<Integer> tempStore=new ArrayList<>();
            for(int i:nums){
                tempStore.add(i);
            }
            storage.add(new ArrayList<>(tempStore));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swapper(index,i,nums);
            permutationMakerWithoutSpace(nums,storage,index+1);
            swapper(index,i,nums);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<Integer> tempStorage=new ArrayList<>();
        List<List<Integer>> storage=new ArrayList<>();
        int[] freq=new int[nums.length];
        permutationOfArray obj= new permutationOfArray();
        // With Extra Space
        obj.permutationMaker(nums,tempStorage,storage,freq);
        obj.printing(storage);

        // Without Any Extra Space
        obj.permutationMakerWithoutSpace(nums,storage,0);
        obj.printing(storage);
    }
}
