import java.util.LinkedList;
import java.util.Queue;

public class firstNegativeIntegerSizeK {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public long[] printFirstNegativeInteger(long array[], int N, int K)
    {
        long[] output=new long[N-K+1];
        Queue<Integer> queue=new LinkedList<>();
        int left=0,right=0,index=0;
        while(right<array.length){
            if(array[right]<0) queue.add(right);
            if(right-left+1<K) right++;
            else{
                if(queue.isEmpty()) output[index++]=0;
                else{
                    output[index++]=array[queue.peek()];
                }
                if(!queue.isEmpty() && queue.peek()==left) queue.poll();
                left++;
                right++;
            }
        }
        return output;

    }
}
