public class findTheTownJudge {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int findJudge(int n, int[][] trust) {
        int[] trustLevel=new int[n+1];
        for(int i=0;i<trust.length;i++){
            trustLevel[trust[i][0]]-=1;
            trustLevel[trust[i][1]]+=1;
        }
        for(int i=1;i<n+1;i++){
            if(trustLevel[i]==n-1) return i;
        }
        return -1;
    }
}
