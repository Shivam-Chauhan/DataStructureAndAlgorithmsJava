import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public List<Integer> spiralMatrixPrinterFunction(int[][] matrix) {
        List<Integer> storage = new ArrayList<>();
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1, chance = 0;
        while (top <= down && left <= right) {
            if (chance % 4 == 0) {
                for (int i = left; i <= right; i++) {
                    storage.add(matrix[top][i]);
                }
                top++;
            }
            if (chance % 4 == 1) {
                for (int i = top; i <= down; i++) {
                    storage.add(matrix[i][right]);
                }
                right--;
            }
            if (chance % 4 == 2) {
                for (int i = right; i >= left; i--) {
                    storage.add(matrix[down][i]);
                }
                down--;
            }
            if (chance % 4 == 3) {
                for (int i = down; i >= top; i--) {
                    storage.add(matrix[i][left]);
                }
                left++;
            }
            chance++;
        }
        return storage;
    }
}
