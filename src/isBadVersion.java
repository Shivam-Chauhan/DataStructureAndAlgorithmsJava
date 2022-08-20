public class isBadVersion {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/first-bad-version/
    public int firstBadVersion(int n) {
        int low=1,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
//            if(isBadVersion(mid)) high=mid-1;
//            else low=mid+1;
//            Uncomment it when executing code on Leetcode
        }
        return low;
    }
}
