public class onesAndZeroes {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*Zeroes*Ones)
    // Link :- https://leetcode.com/problems/ones-and-zeroes/
    public int findMaxFinder(String[] strs, int zeroes, int ones, int index, int[][][] grid) {
        if (index < 0 || (zeroes <= 0 && ones <= 0)) return 0;
        if (grid[index][zeroes][ones] != 0) return grid[index][zeroes][ones];
        int counter1 = 0, counter0 = 0;
        for (char ch : strs[index].toCharArray()) {
            if (ch == '0') counter0++;
            else counter1++;
        }
        if (counter0 <= zeroes && counter1 <= ones) {
            return grid[index][zeroes][ones] = Math.max(
                    1 + findMaxFinder(strs, zeroes - counter0, ones - counter1, index - 1, grid),
                    findMaxFinder(strs, zeroes, ones, index - 1, grid));
        }
        return grid[index][zeroes][ones] = findMaxFinder(strs, zeroes, ones, index - 1, grid);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] grid = new int[strs.length + 1][m + 1][n + 1];
        return findMaxFinder(strs, m, n, strs.length - 1, grid);
    }
}
