import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationofArrayTwo {
    public void printing(List<List<Integer>> storage) {
        for (int i = 0; i < storage.size(); i++) {
            for (int j : storage.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Time Complexity :- O(N!) + O(N) + O(N*Log(N))
    // Space Complexity :- O(N) + O(N) + Recursion Stack
    public void permutationMaker(int[] nums, List<Integer> tempStorage,
                                 List<List<Integer>> storage, int[] freq) {
        if (tempStorage.size() == nums.length) {
            storage.add(new ArrayList<>(tempStorage));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == 1) continue;
            if (i > 0 && nums[i - 1] == nums[i] && freq[i - 1] == 0) continue;
            freq[i] = 1;
            tempStorage.add(nums[i]);
            permutationMaker(nums, tempStorage, storage, freq);
            freq[i] = 0;
            tempStorage.remove(tempStorage.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<Integer> tempStorage = new ArrayList<>();
        List<List<Integer>> storage = new ArrayList<>();
        int[] freq = new int[nums.length];
        Arrays.sort(nums);
        permutationofArrayTwo obj = new permutationofArrayTwo();
        // With Extra Space
        obj.permutationMaker(nums, tempStorage, storage, freq);
        obj.printing(storage);
    }
}


