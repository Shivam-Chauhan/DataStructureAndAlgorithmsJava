public class longestSubStringWithoutRepeatingCharacter {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int checker(int[] storage) {
        int counter = 0;
        for (int i : storage) counter += i >= 2 ? 1 : 0;
        return counter;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] storage = new int[256];
        int left = 0, right = 0, maxi = 0;
        while (right < s.length()) {
            storage[s.charAt(right)] += 1;
            while (checker(storage) > 0) {
                storage[s.charAt(left)] -= 1;
                left++;
            }
            if (checker(storage) == 0) maxi = Math.max(maxi, right - left + 1);
            right++;
        }
        return maxi;
    }
}
