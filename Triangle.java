// TC: O(n^2)
// SC: O(n^2)

// 1: We maintain a dp array initially filled with max integer value. then we recursively iterate through each element in the List to find the minimum path
// 2: For each element, we calculate the minimum between the elements on the next row that can be chosen plus the current path sum and add to dp array
// 3: If we revisit any element, we use the value from the dp array to avoid duplicate calls
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        return helper(triangle, 0, 0, dp);
    }

    private int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        // base
        if (i == triangle.size())
            return 0;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        // logic
        int case1 = helper(triangle, i + 1, j, dp);
        int case2 = helper(triangle, i + 1, j + 1, dp);
        dp[i][j] = Math.min(case1, case2) + triangle.get(i).get(j);
        return dp[i][j];
    }
}