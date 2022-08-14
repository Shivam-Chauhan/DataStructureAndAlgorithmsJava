import java.util.ArrayList;
import java.util.List;

public class mColoringGraph {
    // Time Complexity :- O(M^N)
    // Space Complexity :- O(N) + Recursion Stack
    // Link :- https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
    public boolean isSafe(int[] color, List<List<Integer>> graph, int colorWanted, int index) {
        for (int i : graph.get(index)) {
            if (color[i] == colorWanted) return false;
        }
        return true;
    }
    public boolean coloring(List<List<Integer>> graph, int index, int[] color, int n, int m) {
        if (index == n) return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(color, graph, i, index)) {
                color[index] = i;
                if (coloring(graph, index + 1, color, n, m)) {
                    return true;
                }
                color[index] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean[][] graph, int m, int n) {
        List<List<Integer>> grid = new ArrayList<>();
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j])
                    grid.get(i).add(j);

            }
        }
        return coloring(grid, 0, color, n, m);
    }
}
