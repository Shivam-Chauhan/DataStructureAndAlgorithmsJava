import java.util.PriorityQueue;
// Time Complexity For Adding :- O(1)
// Time Complexity For Finding :- O(1)
// Space Complexity :- O(N)
// Link :- https://leetcode.com/problems/find-median-from-data-stream/submissions/
public class medianOfDataStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public medianOfDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
        else minHeap.add(num);
        if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        return maxHeap.peek();
    }
}
