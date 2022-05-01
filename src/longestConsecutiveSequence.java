import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int longestConsecutiveSequenceUtil(int[] nums){
        int longestStreak=0;
        Set<Integer> storage=new HashSet<>();
        for(int i:nums){
            storage.add(i);
        }
        for(int i: nums){
            if(storage.contains(i-1)==false){
                int currentNum=i;
                int currentStreak=1;
                while(storage.contains(currentNum+1)==true){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        longestConsecutiveSequence obj=new longestConsecutiveSequence();
        System.out.println(obj.longestConsecutiveSequenceUtil(nums));

    }
}
