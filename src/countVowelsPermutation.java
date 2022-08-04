import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class countVowelsPermutation {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/count-vowels-permutation/
    int MOD = 1000000007;
    public int dfs(int n, HashMap<Integer, ArrayList<Integer>> hashMap, int index, int[][] grid) {
        if (n == 1) return 1;
        if (grid[n][index] != 0) return grid[n][index];
        int counter = 0;
        for (int i : hashMap.get(index)) {
            counter = (counter % (MOD) + (dfs(n - 1, hashMap, i, grid) % (MOD))) % (MOD);
        }
        return grid[n][index] = counter;
    }

    public int countVowelPermutation(int n) {
        int[][] grid = new int[n + 1][5];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put(0, new ArrayList<>(Arrays.asList(1)));
        hashMap.put(1, new ArrayList<>(Arrays.asList(0, 2)));
        hashMap.put(2, new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        hashMap.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        hashMap.put(4, new ArrayList<>(Arrays.asList(0)));
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            counter = (counter % (MOD) + (dfs(n, hashMap, i, grid) % (MOD))) % (MOD);
        }
        return counter;
    }
}
