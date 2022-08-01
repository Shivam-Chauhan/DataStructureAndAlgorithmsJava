public class bitonicSubsequence {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N)
    // Link :- https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int longestBitonicSequenceFinder(int[] arr, int n) {
        int[] increasingLeft = new int[n];
        int[] increasingRight = new int[n];
        for (int i = 0; i < n; i++) {
            int maxi = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) maxi = Math.max(maxi, increasingLeft[j]);
            }
            increasingLeft[i] = maxi + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int maxi = 0;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) maxi = Math.max(maxi, increasingRight[j]);
            }
            increasingRight[i] = maxi + 1;
        }
        int overAllMaxi = 0;
        for (int i = 0; i < n; i++) {
            overAllMaxi = Math.max(overAllMaxi, increasingLeft[i] + increasingRight[i] - 1);
        }
        return overAllMaxi;
    }
    public static int longestBitonicSequence(int[] arr, int n) {
        return longestBitonicSequenceFinder(arr, n);
    }
}
