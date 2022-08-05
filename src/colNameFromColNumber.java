public class colNameFromColNumber {
    // Time Complexity :- O(Log(Base26(N)))
    // Space Complexity :- O(N)
    // Link:- https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1
    String colName(long n) {
        StringBuilder string = new StringBuilder();
        while (n > 0) {
            long remainder = n % 26;
            if (remainder == 0) {
                string.append('Z');
                n = n / 26 - 1;
            } else {
                string.append((char) ((remainder - 1) + 'A'));
                n = n / 26;
            }
        }
        string.reverse();
        return string.toString();
    }
}
