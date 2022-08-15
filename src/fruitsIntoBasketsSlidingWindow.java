import java.util.HashMap;

public class fruitsIntoBasketsSlidingWindow {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/fruit-into-baskets/
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int right = 0, left = 0, maxi = 0;
        while (right < fruits.length) {
            if (hashMap.containsKey(fruits[right])) hashMap.put(fruits[right], hashMap.get(fruits[right]) + 1);
            else hashMap.put(fruits[right], 1);
            while (hashMap.size() > 2) {
                hashMap.put(fruits[left], hashMap.get(fruits[left]) - 1);
                if (hashMap.get(fruits[left]) == 0) hashMap.remove(fruits[left]);
                left++;
            }
            if (hashMap.size() <= 2) maxi = Math.max(maxi, right - left + 1);
            right++;
        }
        return maxi;
    }
}
