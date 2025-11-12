/*
* Approach 1: Recursion + memoization
- Idea is to explore the triangle and decide which element to choose: ith or i + 1th.
- Memoize the computed values and use that in the repeated subproblems
- TC: O(n^2) -> iterate over all the elements of list of list
-SC: O(n^2) -> dp matrix to store computed values for the repeated subproblems
 */
class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.memo = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int r, int c){
        //base
        if(r == triangle.size())
            return 0;
        // logic
        if(memo[r][c] != Integer.MIN_VALUE)
            return memo[r][c];
        //choose ith
        int case1 = triangle.get(r).get(c) + helper(triangle, r+1, c);
        //choose i+1th
        int case2 = triangle.get(r).get(c) + helper(triangle, r+1, c+1);
        memo[r][c] = Math.min(case1, case2);
        return Math.min(case1, case2);

    }
}

/*
* Approach2: Tabulation
- Start from the second last row and move upwards
- get the min value between the ith and i+1th index and replace the value of the curr index with the min val + current index val as the reference for above unexplored rows
- TC: O(n^2) -> iterating the triangle
- SC: O(1) -> no additional space used
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for(int i = n - 2; i >=0; i--){
            for(int j = 0; j <= i; j++){
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, curr + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}