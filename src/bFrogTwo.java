public class bFrogTwo {
    // Time Complexity :- O(N*K)
    // Space Complexity :- O(N)
    // Link :- https://atcoder.jp/contests/dp/tasks/dp_b
    public int bFrogTwoFinder(int[] array, int k, int index, int[] storage) {
        if (index < 0) return Integer.MAX_VALUE;
        if (index == 0) return 0;
        if (storage[index] != -1) return storage[index];
        int minimal = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = bFrogTwoFinder(array, k, index - i, storage) + Math.abs(array[index] - array[index - i]);
                minimal = Math.min(minimal, jump);
            }
        }
        return storage[index] = minimal;
    }

    public static void main(String[] args) {
        int[] array = {10, 30, 40, 50, 20};
        int k = 3;
        int[] storage = new int[array.length];
        for (int i = 0; i < array.length; i++) storage[i] = -1;
        bFrogTwo obj = new bFrogTwo();
        System.out.println(obj.bFrogTwoFinder(array, k, array.length - 1, storage));
    }
}
