public class reverseAStringThree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link:- https://leetcode.com/problems/reverse-words-in-a-string-iii/
    public void reverse(char[] string1, int left, int right) {
        while (left < right) {
            char temp = string1[left];
            string1[left] = string1[right];
            string1[right] = temp;
            left++;
            right--;

        }
    }

    public String reverseWords(String s) {
        char[] string1 = s.toCharArray();
        int left = 0;
        for (int right = 0; right < string1.length; right++) {
            if (string1[right] == ' ') {
                reverse(string1, left, right - 1);
                left = right + 1;
            }
        }
        reverse(string1, left, string1.length - 1);
        return new String(string1);

    }
}
