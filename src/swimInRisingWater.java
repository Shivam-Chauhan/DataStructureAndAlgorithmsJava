import java.util.PriorityQueue;

public class swimInRisingWater {
    // Time Complexity :- O(N*N*Log(N))
    // Space Complexity :- O(N+E) + O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/swim-in-rising-water/
    public int swimmer(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[]{0, 0, grid[0][0]}); // xCor, yCor,distance
        int n = grid.length;
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        int result = (int) 1e9;
        while (minHeap.size() > 0) {
            int[] array = minHeap.poll();
            int xcor = array[0];
            int ycor = array[1];
            int distance = array[2];
            if (xcor == grid.length - 1 && ycor == grid[0].length - 1) result = Math.min(result, distance);
            for (int[] i : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int newX = xcor + i[0], newY = ycor + i[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                    minHeap.add(new int[]{newX, newY, Math.max(distance, grid[newX][newY])});
                    visited[newX][newY] = 1;
                }
            }
        }
        return result;
    }

    public int swimInWater(int[][] grid) {
        return swimmer(grid);
    }
}
