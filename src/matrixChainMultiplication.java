public class matrixChainMultiplication {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int matrixFinder(int[] arr, int left, int right, int[][] grid) {
        if (left == right) return 0;
        if (grid[left][right] != -1) return grid[left][right];
        int minValue = (int) 1e9;
        for (int k = left; k < right; k++) {
            int steps = arr[left - 1] * arr[k] * arr[right] +
                    matrixFinder(arr, left, k, grid) + matrixFinder(arr, k + 1, right, grid);
            minValue = Math.min(minValue, steps);
        }
        return grid[left][right] = minValue;
    }
}
