import java.util.HashMap;
import java.util.PriorityQueue;

public class networkDelayTime {
    // Time Complexity :- O(N^2Log(E))
    // Space Complexity :- O(N) + O(N)
    // Link :- https://leetcode.com/problems/network-delay-time/
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int[] index : times) {
            graph.putIfAbsent(index[0], new HashMap<>());
            graph.get(index[0]).put(index[1], index[2]); // u,v,distance
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.add(new int[]{0, k}); // Distance, Node;
        boolean[] visited = new boolean[n + 1];
        int result = 0;
        while (minHeap.size() > 0) {
            int[] curr = minHeap.remove();
            int distance = curr[0];
            int node = curr[1];
            if (visited[node]) continue;
            visited[node] = true;
            n--;
            result = distance;
            if (graph.containsKey(node)) {
                for (int i : graph.get(node).keySet())
                    minHeap.add(new int[]{distance + graph.get(node).get(i), i});
            }
        }
        return n == 0 ? result : -1;
    }
}
