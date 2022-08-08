import java.util.ArrayList;
import java.util.List;

public class minVerticesToReachAllNode {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> output = new ArrayList<>();
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) output.add(i);
        }
        return output;

    }
}
