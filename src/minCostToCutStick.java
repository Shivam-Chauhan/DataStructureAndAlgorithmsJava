import java.util.Arrays;
import java.util.HashMap;

public class minCostToCutStick {
    // Time Complexity :- O(N*M))
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
    public int minCostFinder(int[] cutter, int left, int right, HashMap<String, Integer> hashMap) {
        String string = left + "_" + right;
        if (left > right) return 0;
        if (hashMap.containsKey(string)) return hashMap.get(string);
        int mini = (int) 1e9;
        for (int index = left; index <= right; index++) {
            int value = (cutter[right + 1] - cutter[left - 1]) +
                    minCostFinder(cutter, left, index - 1, hashMap) + minCostFinder(cutter, index + 1, right, hashMap);
            mini = Math.min(value, mini);
        }
        hashMap.put(string, mini);
        return mini;
    }

    public int minCost(int n, int[] cuts) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int[] cutter = new int[cuts.length + 2];
        for (int i = 1; i <= cuts.length; i++) cutter[i] = cuts[i - 1];
        cutter[cuts.length + 1] = n;
        Arrays.sort(cutter);
        return minCostFinder(cutter, 1, cuts.length, hashMap);
    }
}
