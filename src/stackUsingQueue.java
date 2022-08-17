import java.util.LinkedList;
import java.util.Queue;
// Time Complexity :- O(N)
// Space Complexity :- O(N)
public class stackUsingQueue {
    Queue<Integer> queue;
    public stackUsingQueue(){
        queue=new LinkedList<>();
    }
    public void push(int x){
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
    }
    public int top(){
        if(queue.isEmpty()) return -1;
        return queue.peek();
    }
    public int poll(){
        if(queue.isEmpty()) return -1;
        return queue.poll();
    }
    public static void main(String[] args) {
        stackUsingQueue obj=new stackUsingQueue();
        obj.push(12);
        obj.push(12);
        obj.push(12);
        obj.push(12);
        System.out.println(obj.poll());
        System.out.println(obj.poll());
        System.out.println(obj.poll());
        System.out.println(obj.poll());
        System.out.println(obj.poll());
        System.out.println(obj.top());
    }
}
