public class countOccurenceOfAnagrams {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
    boolean checker(int[] patHash, int[] txtHash) {
        for (int i = 0; i < patHash.length; i++) {
            if (patHash[i] != txtHash[i]) return false;
        }
        return true;
    }

    int search(String pat, String txt) {
        int[] patHash = new int[26];
        int[] txtHash = new int[26];
        int left = 0, right = 0, counter = 0;
        for (int i = 0; i < pat.length(); i++) {
            patHash[pat.charAt(i) - 'a'] += 1;
        }
        while (right < txt.length()) {
            txtHash[txt.charAt(right) - 'a'] += 1;
            if (right - left + 1 < pat.length()) {
                right++;
            } else {
                if (checker(txtHash, patHash)) counter++;
                txtHash[txt.charAt(left) - 'a'] -= 1;
                left++;
                right++;
            }
        }
        return counter;

    }
}
