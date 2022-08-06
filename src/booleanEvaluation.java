public class booleanEvaluation {
    // Time Complexity :- O(N*M*N))
    // Space Complexity :- O(N*M*N) + Auxillary Space Of Recursion Stack
    // Link:- https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    static int MOD = 1000000007;

    public static int evaluater(int left, int right, int isTrue, String exp, int[][][] grid) {
        if (left > right) return 0;
        if (left == right) {
            if (isTrue == 1) return exp.charAt(left) == 'T' ? 1 : 0;
            else return exp.charAt(left) == 'F' ? 1 : 0;
        }
        if (grid[left][right][isTrue] != -1) return grid[left][right][isTrue];
        long ways = 0;
        for (int index = left + 1; index <= right - 1; index++) {
            long lT = evaluater(left, index - 1, 1, exp, grid);
            long lF = evaluater(left, index - 1, 0, exp, grid);
            long rT = evaluater(index + 1, right, 1, exp, grid);
            long rF = evaluater(index + 1, right, 0, exp, grid);
            if (exp.charAt(index) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if (exp.charAt(index) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lT * rT) % MOD + (lF * rF) % MOD) % MOD;
                }
            }
        }
        return grid[left][right][isTrue] = (int) ways;
    }

    public static int evaluateExp(String exp) {
        int[][][] grid = new int[exp.length() + 1][exp.length() + 1][2];
        for (int i = 0; i <= exp.length(); i++)
            for (int j = 0; j < exp.length(); j++)
                for (int k = 0; k < 2; k++)
                    grid[i][j][k] = -1;
        return evaluater(0, exp.length() - 1, 1, exp, grid);
    }
}
