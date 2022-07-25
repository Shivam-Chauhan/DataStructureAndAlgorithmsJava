import java.util.Arrays;

public class maxUnitOfTruckSize {
    // Time Complexity for inserting :- O(N*Log(N))
    // Space Complexity for Finding  :- O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int total = 0;
        for (int[] i : boxTypes) {
            if (i[0] <= truckSize) {
                total += i[0] * i[1];
                truckSize -= i[0];
            } else {
                total += truckSize * i[1];
                truckSize = 0;
            }
        }
        return total;
    }
}
