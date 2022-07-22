import java.util.ArrayList;
public class findTheMostCompetitveSequence {
    // Problem Sol:- https://leetcode.com/problems/find-the-most-competitive-subsequence/discuss/1027495/Python-Stack-solution-explained
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayList<Integer> array=new ArrayList<>();
        int attempt=nums.length-k;
        for(int element:nums){
            while(!array.isEmpty() && array.get(array.size()-1)>element && attempt>0){
                array.remove(array.size()-1);
                attempt--;
            }
            array.add(element);
        }
        int[] output=new int[k];
        for(int i=0;i<k;i++){
            output[i]=array.get(i);
        }
        return output;
    }
}
