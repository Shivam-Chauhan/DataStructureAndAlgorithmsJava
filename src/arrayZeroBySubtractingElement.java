import java.util.HashSet;

public class arrayZeroBySubtractingElement {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (i != 0) hashSet.add(i);
        }
        return hashSet.size();

    }
}
