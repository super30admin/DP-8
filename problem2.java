// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are using memoization to opimise the problem
we use DFS to get the min using 0,1 recursion and store that
result in memo matrix to optimise the recursion
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return helper(triangle, 0, 0, memo);
    }

    private int helper(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        // base
        if (i == triangle.size())
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];

        // logic
        int re = triangle.get(i).get(j) + Math.min(
                helper(triangle, i + 1, j, memo),
                helper(triangle, i + 1, j + 1, memo));
        memo[i][j] = re;
        return re;
    }
}