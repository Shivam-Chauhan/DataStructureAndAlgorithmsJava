import java.util.PriorityQueue;

public class minAndMaxHeap {
    public static void main(String[] args) {
        int[] array={5,3,8,9,1,2};
        // MinHeap Implementation
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int element: array) minHeap.add(element);
        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+ " ");
        }
        System.out.println();

        // MaxHeap Implementation
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int element: array) maxHeap.add(element);
        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll()+ " ");
        }
        System.out.println();


    }
}
