import java.util.PriorityQueue;

// Time Complexity :- O(N*M) + O((N+M)*Log(N*M))
// Space Complexity :- O(N*M)
// Link :- https://leetcode.com/problems/path-with-minimum-effort/
public class pathWithMinEffortGraph {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] maxStorage = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) maxStorage[i][j] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, 0, 0});
        maxStorage[0][0] = 0;
        while (!minHeap.isEmpty()) {
            int[] array = minHeap.poll();
            int diff = array[0], x = array[1], y = array[2];
            if (x == row - 1 && y == col - 1) return diff;
            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                    int nextEffort = Math.max(diff, Math.abs(heights[x][y] - heights[newX][newY]));
                    if (maxStorage[newX][newY] > nextEffort) {
                        maxStorage[newX][newY] = nextEffort;
                        minHeap.add(new int[]{nextEffort, newX, newY});
                    }

                }
            }
        }
        return -1;
    }
}
