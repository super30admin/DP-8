// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.memo = new Integer[n+1][n+1];
        return dfs(triangle, 0,0);
    }

    private int dfs(List<List<Integer>> triangle, int r, int c){
        if(r == triangle.size()) return 0;

        if(memo[r][c] != null){
            return memo[r][c];
        }

        //logic
        int case0 = dfs(triangle, r+1, c);
        memo[r+1][c] = case0;
        int case1 = dfs(triangle, r+1, c+1);
        memo[r+1][c+1] = case1;

        memo[r][c]= Math.min(case0, case1) + triangle.get(r).get(c);

        return memo[r][c];
    }
}