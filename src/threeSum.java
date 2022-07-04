import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSumFunction(int[] nums) {
        List<List<Integer>> storage = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 2; index++) {
            if (index == 0 || (index > 0 && nums[index - 1] != nums[index])) {
                int low = index + 1, high = nums.length - 1;
                while (low < high) {
                    List<Integer> tempArray = new ArrayList<>();
                    if (nums[index] + nums[low] + nums[high] == 0) {
                        tempArray.add(nums[index]);
                        tempArray.add(nums[low]);
                        tempArray.add(nums[high]);
                        storage.add(tempArray);
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    } else if (nums[index] + nums[low] + nums[high] > 0) high--;
                    else low++;
                }
            }
        }
        return storage;
    }
}

