import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findPathExist {
    // Time Complexity :- O(N+E)
    // Space Complexity :- O(N+E)
    // Link :- https://leetcode.com/problems/find-if-path-exists-in-graph/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(source);
        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            visited[currNode] = true;
            if (currNode == destination) return true;
            for (int node : graph.get(currNode)) {
                if (visited[node] == false) queue.add(node);
            }
        }
        return false;

    }
}
