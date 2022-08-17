import java.util.Arrays;

public class minPlatForm {
    // Time Complexity :- O(2*(N*Log(N))) + O(N)
    // Space Complexity :- O(1)
    // Link :- https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platForm = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platForm++;
                i++;
            } else if (arr[i] > dep[j]) {
                platForm--;
                j++;
            }
            result = Math.max(result, platForm);
        }
        return result;
    }
}
