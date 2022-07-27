public class frogJump {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public static int frogJumpCounter(int index, int[] heights, int[] storage) {
        if (index < 0) return Integer.MAX_VALUE;
        if (index == 0) return 0;
        if (storage[index] != 0) return storage[index];
        int leftTree = frogJumpCounter(index - 1, heights, storage) + Math.abs(heights[index] - heights[index - 1]);
        int rightTree = Integer.MAX_VALUE;
        if (index - 2 >= 0) {
            rightTree = frogJumpCounter(index - 2, heights, storage) + Math.abs(heights[index] - heights[index - 2]);
        }
        return storage[index] = Math.min(leftTree, rightTree);
    }

    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public static int frogJumpCounterOptimal(int[] heights) {
        int previous1 = 0, previous2 = 0;
        for (int index = 1; index < heights.length; index++) {
            int first = previous1 + Math.abs(heights[index] - heights[index - 1]);
            int second = Integer.MAX_VALUE;
            if (index - 2 >= 0) {
                second = previous2 + Math.abs(heights[index] - heights[index - 2]);
            }
            int current = Math.min(first, second);
            previous2 = previous1;
            previous1 = current;
        }
        return previous1;
    }
}
