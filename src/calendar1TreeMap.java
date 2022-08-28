import java.util.Map;
import java.util.TreeMap;

public class calendar1TreeMap {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/my-calendar-i/
    TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public calendar1TreeMap() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}
