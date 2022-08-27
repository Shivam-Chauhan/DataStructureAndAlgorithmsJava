public class reorderPowerOfTwo {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/reordered-power-of-2/
    public void containerFiller(int num, int[] container) {
        while (num > 0) {
            container[num % 10]++;
            num /= 10;
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] permanentContainer = new int[10];
        containerFiller(n, permanentContainer);
        int i = 0;
        while (i <= 31) {
            int[] container = new int[10];
            int flag = 0;
            containerFiller(1 << i, container);
            for (int j = 0; j < 10; j++) {
                if (container[j] != permanentContainer[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return true;
            i++;
        }
        return false;
    }
}
