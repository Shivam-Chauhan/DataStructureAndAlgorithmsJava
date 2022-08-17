import java.util.ArrayList;
import java.util.List;

public class minNumberOfCoinsGreedy {
    // Time Complexity :- O(N*ConstantFactor)
    // Space Complexity :- O(1)
    // Link :- https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
    static List<Integer> minPartition(int N) {
        List<Integer> output = new ArrayList<>();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        for (int i = coins.length - 1; i >= 0; i--) {
            while (N >= coins[i]) {
                output.add(coins[i]);
                N -= coins[i];
            }
        }
        return output;
    }
}
