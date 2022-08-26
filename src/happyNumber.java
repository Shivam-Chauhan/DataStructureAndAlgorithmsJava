public class happyNumber {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/happy-number/
    public int finder(int n) {
        int summation = 0;
        while (n > 0) {
            int tempNum = n % 10;
            summation += (tempNum * tempNum);
            n /= 10;
        }
        return summation;
    }

    public boolean isHappy(int n) {
        int counter = 0;
        while (counter < 27) {
            int tempNum = finder(n);
            if (tempNum == 1) return true;
            counter++;
            n = tempNum;
        }
        return false;
    }
}
