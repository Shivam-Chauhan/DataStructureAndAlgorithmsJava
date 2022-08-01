import java.util.ArrayList;

public class longestIncreasingSubsequence {

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(2^N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // Link :- https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int longestIncreasingFinder(int[] arr, int index, int prevIndex) {
        if (index >= arr.length) return 0;
        int notTake = longestIncreasingFinder(arr, index + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || arr[prevIndex] < arr[index])
            take = longestIncreasingFinder(arr, index + 1, index) + 1;
        return Math.max(notTake, take);
    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public int longestIncreasingFinder(int[] arr, int index, int prevIndex, int[][] grid) {
        if (index >= arr.length) return 0;
        if (grid[index][prevIndex + 1] != -1) return grid[index][prevIndex + 1];
        int notTake = longestIncreasingFinder(arr, index + 1, prevIndex, grid);
        int take = 0;
        if (prevIndex == -1 || arr[prevIndex] < arr[index])
            take = longestIncreasingFinder(arr, index + 1, index, grid) + 1;
        return grid[index][prevIndex + 1] = Math.max(notTake, take);
    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N)
    // Link :- https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int longestIncreasingFinder(int[] arr) {
        int[] storage = new int[arr.length];
        int output = 0;
        for (int index = 0; index < arr.length; index++) {
            int tempMaxi = 0;
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[prevIndex] < arr[index])
                    tempMaxi = Math.max(tempMaxi, storage[prevIndex]);
            }
            storage[index] = 1 + tempMaxi;
            output = Math.max(output, storage[index]);
        }

        return output;
    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/longest-increasing-subsequence/submissions/
    public int binarySearchFinder(ArrayList<Integer> storage, int target) {
        int low = 0, high = storage.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (storage.get(mid) == target) return mid;
            else if (storage.get(mid) < target) low = mid + 1;
            else high = mid - 1;

        }
        return high + 1;
    }

    public int longestIncreasingFinderOptimal(int[] arr) {
        ArrayList<Integer> storage = new ArrayList<>();
        storage.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > storage.get(storage.size() - 1)) storage.add(arr[i]);
            else {
                int index = binarySearchFinder(storage, arr[i]);
                storage.set(index, arr[i]);
            }
        }
        return storage.size();
    }
}
