public class dungeonGame {
    public int calculateMinFinder(int[][] array) {
        int[][] grid = new int[array.length][array[0].length];
        for (int row = array.length - 1; row >= 0; row--) {
            for (int col = array[0].length - 1; col >= 0; col--) {
                if (row == array.length - 1 && col == array[0].length - 1) {
                    grid[row][col] = Math.min(0, array[row][col]);
                } else if (row == array.length - 1) {
                    grid[row][col] = Math.min(0, array[row][col] + grid[row][col + 1]);

                } else if (col == array[0].length - 1) {
                    grid[row][col] = Math.min(0, array[row][col] + grid[row + 1][col]);
                } else {
                    if (Math.abs(grid[row][col + 1]) > Math.abs(grid[row + 1][col]))
                        grid[row][col] = Math.min(0, array[row][col] + grid[row + 1][col]);
                    else
                        grid[row][col] = Math.min(0, array[row][col] + grid[row][col + 1]);
                }
            }
        }
        return Math.abs(grid[0][0]) + 1;
    }
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/dungeon-game/
    public int calculateMinimumHP(int[][] dungeon) {
        return calculateMinFinder(dungeon);
    }
}
