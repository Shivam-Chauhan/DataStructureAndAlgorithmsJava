import java.util.Collections;
import java.util.PriorityQueue;

public class furthestBuildingYouCanReach {
    // Time Complexity :- O(N*Log(K))
    // Space Complexity :- O(N)
    public int furthestBuildingYouCanReachFinder(int[] heights, int ladder, int bricks) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < heights.length - 1; index++) {
            if (heights[index + 1] >= heights[index]) {
                bricks -= (heights[index + 1] - heights[index]);
                maxHeap.add(heights[index + 1] - heights[index]);
            }
            if (bricks < 0) {
                bricks += maxHeap.poll();
                if (ladder > 0) ladder--;
                else return index;
            }
        }
        return heights.length - 1;
    }
}
