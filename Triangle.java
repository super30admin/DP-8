import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalMemo(triangle);
    }

    // TC: O(N * N) where N is length of triangle
    // SC: O(N * N) where N is length of triangle
    private int minimumTotalMemo(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return dfs(triangle, 0, 0, memo);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        if (row >= triangle.size()) return 0;
        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        int res = triangle.get(row).get(col) + Math.min(dfs(triangle, row + 1, col, memo), dfs(triangle, row + 1, col + 1, memo));
        memo[row][col] = res;
        return res;
    }
    // TC: O(N * N) where N is length of triangle
    // SC: O(1)
    private int minimumTotalDP(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int rows = triangle.size();
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(0));
                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1) , triangle.get(i - 1).get(j)));
                }
            }
        }
        List<Integer> lastRow = triangle.get(rows - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            res = Math.min(res, lastRow.get(i));
        }
        return res;
    }
}
