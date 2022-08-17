public class queueUsingArray {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    int front, rear, counter,lengthOfQueue;
    int[] queue;
    public queueUsingArray(int n){
        this.front=0;
        this.rear=0;
        this.counter=0;
        this.lengthOfQueue=n;
        queue=new int[n];
    }
    public void push(int x){
        if(counter==lengthOfQueue) return;
        queue[rear%lengthOfQueue]=x;
        rear++;
        counter++;
    }
    public int pop(){
        if(counter==0) return -1;
        int element=queue[front%lengthOfQueue];
        front++;
        counter--;
        return element;
    }
    public int top(){
        if(counter==0) return -1;
        return queue[front%lengthOfQueue];
    }
    public static void main(String[] args) {
        queueUsingArray obj=new queueUsingArray(5);
        obj.push(1);
        obj.push(1);
        obj.push(1);
        obj.push(1);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}
