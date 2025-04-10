/*
 * TC: O(n) where n is the number of ITEMS in the triangle
 * SC: O(N) where N is the number of rows in the triangle
 */
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        // go bottom up - first fill the dp array with the bottom row
        // and then use the dp array to choose the min value and add it
        // to the current triangle value
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        // answer will lie at dp[0]
        return dp[0];
    }
}
