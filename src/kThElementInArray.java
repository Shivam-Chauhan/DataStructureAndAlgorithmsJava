import java.util.PriorityQueue;

// Time Complexity :- O(N*Log(K))
// Space Complexity :- O(K)
public class kThElementInArray{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}