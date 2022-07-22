import java.util.Comparator;
import java.util.PriorityQueue;
class PQNode{
    long distance;
    int[] storage;
    public PQNode(long distance, int xCor, int yCor){
        this.distance=distance;
        this.storage =new int[]{xCor, yCor};
    }

}
class NodeOfPQ implements Comparator<PQNode> {
    public int compare(PQNode element1, PQNode element2){
        if(element1.distance<element2.distance) return 1;
        else if(element1.distance>element2.distance) return -1;
        else return 0;
    }
}
public class kClosestPointToOrigin {


    // Time Complexity :- O(N*Log(K))
    // Space Complexity :- O(K)
    public int[][] kClosestPointsFinderReduceComparator(int[][] points, int k){
        int[][] output=new int[k][2];
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });
        for(int[] element:points){
            maxHeap.add(element);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int index=0;
        while(!maxHeap.isEmpty()){
            output[index++]=maxHeap.poll();
        }
        return output;
    }

    // Time Complexity :- O(N*Log(K))
    // Space Complexity :- O(K)
    public int[][] kClosestPointsFinder(int[][] points, int k){
        int[][] output=new int[k][2];
        PriorityQueue<PQNode> maxHeap=new PriorityQueue<>(new NodeOfPQ());
        for(int[] element:points){
            long distance= (long) (Math.pow(element[0],2)+ Math.pow(element[1],2));
            maxHeap.add(new PQNode(distance, element[0],element[1]));
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int index=0;
        while(!maxHeap.isEmpty()){
            PQNode node=maxHeap.poll();
            output[index][0]=node.storage[0];
            output[index][1]=node.storage[1];
            index++;
        }
        return output;
    }
    public static void main(String[] args) {
        int[][] points={
                        {3,3},
                        {-2,4},
                        {5,-1}};
        int k=2;
        kClosestPointToOrigin obj=new kClosestPointToOrigin();
        // Using Class Comparator Function
        obj.kClosestPointsFinder(points,k);
        // Without Using Class Comparator Function
        obj.kClosestPointsFinderReduceComparator(points,k);
    }
}
