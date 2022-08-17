import java.util.Arrays;

// Time Complexity :- O(N*Log(N)) + O(N) + O(N*M)
// Space Complexity :- O(N)
// Link :- https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class jobScheduling {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxi = 0, counter = 0, summation = 0;
        for (int i = 0; i < n; i++) maxi = Math.max(maxi, arr[i].deadline);
        int[] storage = new int[maxi + 1];
        for (int i = 0; i <= maxi; i++) storage[i] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j >= 1; j--) {
                if (storage[j] == -1) {
                    storage[j] = i;
                    summation += arr[i].profit;
                    counter++;
                    break;
                }
            }
        }
        return new int[]{counter, summation};
    }
}


