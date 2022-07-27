public class houseRobberTwo {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int maxSumNonAdjacentOptimal(int[] array) {
        if (array.length == 0) return 0;
        int previous1 = array[0], previous2 = 0;
        for (int i = 1; i < array.length; i++) {
            int pickElement = array[i];
            if (i - 2 >= 0) pickElement += previous2;
            int nonPickElement = previous1;
            int current = Math.max(pickElement, nonPickElement);
            previous2 = previous1;
            previous1 = current;
        }
        return previous1;
    }

    public static void main(String[] args) {
        int[] valueInHouse = {0};
        if (valueInHouse.length == 1) System.out.println((valueInHouse[0]));
        else {
            int[] leftIncluded = new int[valueInHouse.length - 1];

            int[] rightIncluded = new int[valueInHouse.length - 1];
            for (int i = 1; i < valueInHouse.length; i++) leftIncluded[i - 1] = valueInHouse[i];
            for (int i = 0; i < valueInHouse.length - 1; i++) rightIncluded[i] = valueInHouse[i];
            houseRobberTwo obj = new houseRobberTwo();
            System.out.println(Math.max(obj.maxSumNonAdjacentOptimal(leftIncluded),
                    obj.maxSumNonAdjacentOptimal(rightIncluded)));
        }
    }
}
