import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class reorderRoutesAllPathLeadToZero {
    // Time Complexity :- O(N+E)
    // Space Complexity :- O(N) + O(N)+ O(N)
    // Link :- https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i : connections) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
            hashSet.add(i[0] + "->" + i[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        queue.add(0);
        int ans = 0;
        while (queue.size() > 0) {
            int currNode = queue.poll();
            for (int i : graph.get(currNode)) {
                if (visited[i]) continue;
                if (!hashSet.contains(i + "->" + currNode)) ans++;
                queue.add(i);
                visited[i] = true;
            }
        }
        return ans;
    }
}
