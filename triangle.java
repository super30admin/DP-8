// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 mutating triangle
    public static int minimumTotal1(List<List<Integer>> triangle) {
        // null case
        if (triangle == null || triangle.size() == 0)
            return 0;
        // 1 case
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int n = triangle.size();
        // start with second last row
        for (int i = n - 2; i >= 0; i--) {
            // traverse at each row and get minimum from next row add it to current row's
            // index
            // and update current row's element
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int x = triangle.get(i + 1).get(j);
                int y = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(x, y));
            }
        }
        return triangle.get(0).get(0);
    }

    // approch 2 using dp matrix
    public static int minimumTotal2(List<List<Integer>> triangle) {
        // null case
        if (triangle == null || triangle.size() == 0)
            return 0;
        // 1 case
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int n = triangle.size();
        int[][] dp = new int[n][n];
        // populate dp with last row of triangle
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        // start with second last row
        for (int i = n - 2; i >= 0; i--) {
            // traverse at each row from the second last row and getting minimum from
            // dp matrix and add it to current row's element and store it in dp matrix
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    // approch 3 using dp array
    public static int minimumTotal3(List<List<Integer>> triangle) {
        // null case
        if (triangle == null || triangle.size() == 0)
            return 0;
        // 1 case
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int n = triangle.size();
        int[] dp = new int[n];
        // populate dp with last row of triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        // start with second last row
        for (int i = n - 2; i >= 0; i--) {
            // traverse at each row from the second last row and getting minimum from
            // dp array and add it to current row's element and store it in dp matrix
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}