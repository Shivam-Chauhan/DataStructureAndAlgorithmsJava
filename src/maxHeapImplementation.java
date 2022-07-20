import java.util.ArrayList;
// Time Complexity For Inserting :- O(Log(N))
// Time Complexity For Removing :- O(Log(N))
// Space Complexity :- O(1)+ Auxillary Space of Recursion Stack
public class maxHeapImplementation {
    static ArrayList<Integer> maxHeap;
    int capacity=0;
    public maxHeapImplementation(){
        this.maxHeap=new ArrayList<>();
        this.capacity=0;
    }
    public void heapify(int index){
        if(index>=maxHeap.size()) return;
        int maxIndex=2*index;
        if(maxIndex<maxHeap.size()-1 && maxHeap.get(maxIndex)<maxHeap.get(maxIndex+1)){
            maxIndex++;
        }
        if(maxIndex<maxHeap.size()){
            if(maxHeap.get(maxIndex)<=maxHeap.get(index)) return;
            int temp=maxHeap.get(index);
            maxHeap.set(index,maxHeap.get(maxIndex));
            maxHeap.set(maxIndex,temp);
            heapify(maxIndex);
        }

    }
    public void insert(int ele) {
        if (capacity == 0) {
            maxHeap.add(ele);
            capacity++;
        } else {
            maxHeap.add(ele);
            capacity++;
            int index = capacity - 1;
            while (index > 0 && ele > maxHeap.get(index / 2)) {
                maxHeap.set(index, maxHeap.get(index / 2));
                index /= 2;
            }
            maxHeap.set(index, ele);
        }
    }
    public int remove(){
        if(capacity==0) return -1;

        int maxItem=maxHeap.get(0);
        maxHeap.set(0,maxHeap.get(maxHeap.size()-1));
        maxHeap.remove(maxHeap.size()-1);
        capacity-=1;
        heapify(0);
        return maxItem;
    }

    public static void main(String[] args) {
        maxHeapImplementation pq=new maxHeapImplementation();
        pq.insert(12);
        pq.insert(16);
        pq.insert(1);
        pq.insert(112);
        pq.insert(90);
        pq.insert(-1);
        System.out.println(maxHeap);
        pq.remove();
        pq.remove();
        System.out.println(maxHeap);
    }
}
