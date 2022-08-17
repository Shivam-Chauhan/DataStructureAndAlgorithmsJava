import java.util.ArrayList;

public class reversePairs {
    // Time Complexity :- O(N*Log(N)) + O(N) + O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/reverse-pairs/
    public int mergeArray(int[] nums, int low, int mid, int high) {
        int counter = 0, j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) j++;
            counter += j - (mid + 1);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (right <= high)
            temp.add(nums[right++]);
        while (left <= mid)
            temp.add(nums[left++]);
        for (int i = low; i <= high; i++) nums[i] = temp.get(i - low);
        return counter;


    }

    public int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int inversion = mergeSort(nums, low, mid);
        inversion += mergeSort(nums, mid + 1, high);
        inversion += mergeArray(nums, low, mid, high);

        return inversion;

    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
