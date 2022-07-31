public class editDistance {
    public int editDistanceFinder(String str1, String str2, int index1, int index2, int[][] grid) {
        if (index1 < 0) return index2 + 1;
        if (index2 < 0) return index1 + 1;
        if (grid[index1][index2] != -1) return grid[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2))
            return grid[index1][index2] = editDistanceFinder(str1, str2, index1 - 1, index2 - 1, grid);
        return grid[index1][index2] = Math.min(
                1 + editDistanceFinder(str1, str2, index1 - 1, index2, grid),
                Math.min(1 + editDistanceFinder(str1, str2, index1 - 1, index2 - 1, grid),
                        1 + editDistanceFinder(str1, str2, index1, index2 - 1, grid)));
    }

    public int minDistance(String str1, String str2) {
        int[][] grid = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) grid[i][j] = -1;
        }
        return editDistanceFinder(str1, str2, str1.length() - 1, str2.length() - 1, grid);
    }
}
