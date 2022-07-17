public class palindromeNumbers {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public boolean isPalindrome(int x) {
        StringBuilder str=new StringBuilder(String.valueOf(x));
        return str.compareTo((new StringBuilder(str)).reverse())==0?true:false;
    }
}
