public class transfugationTwoPointer {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://practice.geeksforgeeks.org/problems/b6b3297ccfb1ad5f66a9c2b92979170417adf114/1
    int transfigure(String A, String B) {
        if (A.length() != B.length()) return -1;
        int stringLength = A.length();
        int[] stringA = new int[126];
        int[] stringB = new int[126];
        for (int i = 0; i < stringLength; i++) {
            stringA[A.charAt(i)] += 1;
            stringB[B.charAt(i)] += 1;
        }
        for (int i = 0; i < 126; i++)
            if (stringA[i] != stringB[i]) return -1;

        int j = stringLength - 1, result = 0;
        for (int i = stringLength - 1; i >= 0; i--) {
            if (A.charAt(i) == B.charAt(j)) j--;
            else {
                result++;
            }
        }
        return result;
    }
}
