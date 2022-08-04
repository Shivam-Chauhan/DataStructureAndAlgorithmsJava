import java.util.HashMap;

public class numberOfWaysToRemainAtSamePlace {
    // Time Complexity :- O(N*M))
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
    public long numWaysFinder(int steps, int arrLen, int index, HashMap<String, Long> hashMap) {
        if (index == 0 && steps == 0) return 1;
        if (index < 0 || steps == 0 || index >= arrLen) return 0;
        String string = steps + "_" + index;
        if (hashMap.containsKey(string) == true) return hashMap.get(string);
        long leftMoving = numWaysFinder(steps - 1, arrLen, index - 1, hashMap);
        long stay = numWaysFinder(steps - 1, arrLen, index, hashMap);
        long rightMoving = numWaysFinder(steps - 1, arrLen, index + 1, hashMap);
        long ans = (leftMoving + stay + rightMoving) % 1000000007;
        hashMap.put(string, ans);
        return ans;
    }

    public int numWays(int steps, int arrLen) {
        HashMap<String, Long> hashMap = new HashMap<>();
        return (int) (numWaysFinder(steps, arrLen, 0, hashMap)) % 1000000007;
    }
}
