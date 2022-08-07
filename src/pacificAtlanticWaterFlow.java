import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity :- O(N*M)
// Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
// Link :- https://leetcode.com/problems/pacific-atlantic-water-flow/
public class pacificAtlanticWaterFlow {
    public void dfsTraversal(int[][] heights, int row, int col, boolean[][] visited, int height) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || visited[row][col] || height > heights[row][col])
            return;
        visited[row][col] = true;
        dfsTraversal(heights, row + 1, col, visited, heights[row][col]);
        dfsTraversal(heights, row - 1, col, visited, heights[row][col]);
        dfsTraversal(heights, row, col + 1, visited, heights[row][col]);
        dfsTraversal(heights, row, col - 1, visited, heights[row][col]);

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            dfsTraversal(heights, 0, i, pacific, Integer.MIN_VALUE);
            dfsTraversal(heights, row - 1, i, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < row; i++) {
            dfsTraversal(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfsTraversal(heights, i, col - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    output.add(Arrays.asList(i, j));
                }

            }
        }
        return output;
    }
}
