public class implementstrSTR {
    // Time Complexity:- O(N*M)
    // Space Complexity :- O(1)
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                else if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}
