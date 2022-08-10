import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findAllGrpOfFarmLand {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    // Link :- https://leetcode.com/problems/find-all-groups-of-farmland/
    public int[][] findFarmLandBFS(int[][] land) {
        int row = land.length, col = land[0].length;
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1) {
                    // System.out.println(i+ " "+j);
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int x = i, y = j;
                    while (!queue.isEmpty()) {
                        int[] cor = queue.poll();
                        land[cor[0]][cor[1]] = 0;
                        for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                            int newX = cor[0] + dir[0], newY = cor[1] + dir[1];
                            if (newX >= 0 && newY >= 0 && newX < row && newY < col && land[newX][newY] == 1) {
                                x = Math.max(newX, x);
                                y = Math.max(newY, y);
                                land[newX][newY] = 0;
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                    output.add(new int[]{i, j, x, y});
                }
            }
        }

        return output.toArray(new int[output.size()][]);
    }

    // Time Complexity :- O(N*M*ConstantFactor)
    // Space Complexity :- O(N*M)
    public int[][] findFarmLand(int[][] land) {
        int row = land.length, col = land[0].length;
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1) {
                    int r = i, c = j;
                    while (c < col && land[i][c] == 1) {
                        c++;
                    }
                    while (r < row && land[r][j] == 1) {
                        r++;
                    }
                    r = r == 0 ? 0 : r - 1;
                    c = c == 0 ? 0 : c - 1;
                    for (int tempRow = i; tempRow <= r; tempRow++) {
                        for (int tempCol = j; tempCol <= c; tempCol++) {
                            land[tempRow][tempCol] = 0;
                        }
                    }
                    output.add(new int[]{i, j, r, c});
                }
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
