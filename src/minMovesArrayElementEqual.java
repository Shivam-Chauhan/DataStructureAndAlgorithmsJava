public class minMovesArrayElementEqual {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int minMoves(int[] nums) {
        int summation=0, mini=Integer.MAX_VALUE;
        for(int i:nums){
            summation+=i;
            mini=Math.min(mini,i);
        }
        return summation-mini*nums.length;
    }
}
