import java.util.HashMap;
import java.util.HashSet;

public class makingALargeIsland {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/making-a-large-island/
    public int dfs(int[][] grid, int x, int y, int index) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        grid[x][y] = index;
        return 1 + dfs(grid, x + 1, y, index)
                + dfs(grid, x - 1, y, index)
                + dfs(grid, x, y - 1, index)
                + dfs(grid, x, y + 1, index);
    }

    public int clubMaker(int[][] grid) {
        int index = 3, row = grid.length, col = grid[0].length, result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Create This HashMap
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    hashMap.putIfAbsent(index, dfs(grid, i, j, index));
                    result = Math.max(result, hashMap.get(index++));
                }
            }
        }
        // Now find the neighbours of the zero place
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    int curr = 1;
                    for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}}) {
                        int newX = i + dir[0], newY = j + dir[1];
                        if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                            index = grid[newX][newY];
                            if (index > 1 && !hashSet.contains(index)) {
                                curr += hashMap.get(index);
                                hashSet.add(index);
                            }
                        }
                    }
                    result = Math.max(result, curr);
                }
            }
        }
        return result;
    }

    public int largestIsland(int[][] grid) {
        return clubMaker(grid);
    }
}
