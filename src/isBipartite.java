import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    public boolean isBipartiteGraph(int[][] graph, int[] coloring, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        coloring[node] = 1;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i : graph[val]) {
                if (coloring[i] == coloring[val]) {
                    return false;
                }
                if (coloring[i] == -1) {
                    coloring[i] = 1 - coloring[val];
                    queue.add(i);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        isBipartite obj = new isBipartite();
        int[][] graph = {{1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}};
        int[] coloring = new int[graph.length];
        for (int i = 0; i < coloring.length; i++) coloring[i] = -1;
        int flag = 0;
        for (int i = 0; i < coloring.length; i++) {
            if (coloring[i] == -1) {
                if (!obj.isBipartiteGraph(graph, coloring, i)) {
                    System.out.println(false);
                    flag += 1;
                }
            }
        }
        if (flag == 0) System.out.println(true);
    }
}
