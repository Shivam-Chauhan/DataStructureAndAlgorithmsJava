public class FibonacciNumber {
    public int fibNumberFunction(int n) {
        int previousLast = 0, previousSecond = 1;
        if (n == 0 || n == 1) return n;

        for (int i = 2; i <= n; i++) {
            int sum1 = previousLast + previousSecond;
            previousLast = previousSecond;
            previousSecond = sum1;
        }
        return previousSecond;
    }

    public static void main(String[] args) {
        FibonacciNumber obj=new FibonacciNumber();
        // Time Complexity :- O(N)
        // Space Complexity :- O(1)
        System.out.println(obj.fibNumberFunction(3));
    }


}

