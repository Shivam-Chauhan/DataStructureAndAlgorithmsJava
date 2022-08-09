import java.util.PriorityQueue;

class cell {
    int height, row, col;

    cell(int row, int col, int height) {
        this.height = height;
        this.row = row;
        this.col = col;
    }

}
// Time Complexity :- O(N*M*Log(N*M))
// Space Complexity :- O(N*M)
// Link :- https://leetcode.com/problems/trapping-rain-water-ii/
// Sol Link :- https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
public class trappingRainWaterTwo {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);
        int row = heightMap.length, col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            visited[i][0] = true;
            visited[i][col - 1] = true;
            minHeap.add(new cell(i, 0, heightMap[i][0]));
            minHeap.add(new cell(i, col - 1, heightMap[i][col - 1]));
        }
        for (int j = 0; j < col; j++) {
            visited[0][j] = true;
            visited[row - 1][j] = true;
            minHeap.add(new cell(0, j, heightMap[0][j]));
            minHeap.add(new cell(row - 1, j, heightMap[row - 1][j]));
        }
        while (!minHeap.isEmpty()) {
            cell node = minHeap.poll();
            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}}) {
                int xcor = node.row + dir[0], ycor = node.col + dir[1];
                if (xcor >= 0 && xcor < row && ycor >= 0 && ycor < col && !visited[xcor][ycor]) {
                    visited[xcor][ycor] = true;
                    result += Math.max(0, node.height - heightMap[xcor][ycor]);
                    minHeap.add(new cell(xcor, ycor, Math.max(node.height, heightMap[xcor][ycor])));
                }
            }
        }
        return result;
    }
}
