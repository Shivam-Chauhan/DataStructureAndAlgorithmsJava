import java.util.ArrayList;
import java.util.List;

// Time Complexity :- O(2^N*N*K) // 2^N For recursion, N to check is palindrome, k to insert element in DS
// Space Complexity :- O(K*X) + Recursion Stack // K Avg length of Palindrome and X such palindrome list
// Link :- https://leetcode.com/problems/palindrome-partitioning/
public class palindromePartitioning {
    public boolean isSubStringPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public void partitioner(String s, List<List<String>> output, int index, List<String> temp) {
        if (index == s.length()) {
            output.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isSubStringPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                partitioner(s, output, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        partitioner(s, output, 0, new ArrayList<>());
        return output;
    }
}
