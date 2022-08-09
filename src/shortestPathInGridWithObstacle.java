import java.util.LinkedList;
import java.util.Queue;

public class shortestPathInGridWithObstacle {
    // Time Complexity :- O(N*M*K)
    // Space Complexity :- O(N*M*K)
    // Link :- https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
    // Sol Link :- https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/451796/Java-Straightforward-BFS-O(MNK)-time-or-O(MNK)-space
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][0] = true;
        if (k >= n - 1 + m - 1) {
            return n + m - 2;
        }
        queue.add(new int[]{0, 0, 0, k}); // x,y,steps,k
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int x = array[0], y = array[1], steps = array[2], kSteps = array[3];
            if (x == n - 1 && y == m - 1) return steps;
            for (int[] i : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newX = x + i[0], newY = y + i[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && kSteps - grid[newX][newY] >= 0) {
                    int remain = kSteps - grid[newX][newY];
                    if (visited[newX][newY][remain] == false) {
                        visited[newX][newY][remain] = true;
                        queue.add(new int[]{newX, newY, steps + 1, remain});
                    }
                }
            }
        }
        return -1;
    }
}
