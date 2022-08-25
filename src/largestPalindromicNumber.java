public class largestPalindromicNumber {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N) + O(N) + O(N)
    // Link :- https://leetcode.com/problems/trapping-rain-water/submissions/
    public String largestPalindromic(String num) {
        int[] freqStore = new int[26];
        for (int i = 0; i < num.length(); i++) freqStore[num.charAt(i) - '0']++;
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && front.length() == 0 && back.length() == 0) continue;
            while (freqStore[i] / 2 != 0) {
                front.append((char) (i + '0'));
                back.append((char) (i + '0'));
                freqStore[i] -= 2;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (freqStore[i] != 0) {
                front.append((char) (i + '0'));
                break;
            }
        }
        return front.toString() + back.reverse();
    }
}
