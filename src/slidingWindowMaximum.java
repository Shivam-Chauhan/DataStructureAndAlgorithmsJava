import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link:- https://leetcode.com/problems/sliding-window-maximum/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
        for (int i = k; i < nums.length; i++) {
            output[index++] = nums[queue.peekFirst()];
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        output[index] = nums[queue.peekFirst()];
        return output;
    }
}
