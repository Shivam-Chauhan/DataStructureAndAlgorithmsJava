import java.util.Stack;

// Time Complexity For Push Operation :- O(N)
// Time Complexity For Pop Operation :-  O(1) // Amortized Complexity
// Time Complexity For Top Operation :- O(N) // Amortized Complexity
// Space Complexity :- O(2N)
public class queueUsingStack {
    Stack<Integer> input;
    Stack<Integer> output;

    public queueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int element) {
        input.add(element);
    }

    public int pop() {
        if (!output.isEmpty()) return output.pop();
        while (!input.isEmpty()) output.add(input.pop());
        if (!output.isEmpty()) return output.pop();
        return -1;
    }

    public int top() {
        if (!output.isEmpty()) return output.peek();
        while (!input.isEmpty()) output.add(input.pop());
        if (!output.isEmpty()) return output.peek();
        return -1;
    }

    public static void main(String[] args) {
        queueUsingStack obj = new queueUsingStack();
        obj.push(12);
        obj.push(12);
        obj.push(12);
        obj.push(12);
        obj.push(12);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

}
