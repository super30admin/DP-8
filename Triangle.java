// Time Complexity : O(2^n)
// Space Complexity :O(h) - Recursive Stack Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Approach 1 - Recursion which will lead to TLE because there ar repeated subproblems
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle,0,0);
    }
    
    private int helper(List<List<Integer>> triangle, int list, int index)
    {
        //base
        if(list == triangle.size() - 1)
        {
            return triangle.get(list).get(index);
        }
        //logic
        int case1 = triangle.get(list).get(index) +                                             helper(triangle,list+1,index);
        
        int case2 = triangle.get(list).get(index) + 
                    helper(triangle,list + 1,index + 1);
        
        return Math.min(case1,case2);
    }
}


/*
 * Approach 2 - Bottom Up DP (tabulation) - while mutating the existing data structure
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for(int i = n-2; i>=0; i--)
        {
            for(int j = 0; j < triangle.get(i).size();j++)
            {
                triangle.get(i).set(j,triangle.get(i).get(j) + 
                Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

/*
 * Approach 3 - Using an extra DP array
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i<n; i++)
        {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i = n-2; i>=0; i--)
        {
            for(int j = 0; j < triangle.get(i).size();j++)
            {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}


/*
 * Approach 4 - Using single array instead of using a matrix
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        for(int j = 0; j < n; j++)
        {
            dp[j] = triangle.get(n-1).get(j);
        }
        
        for(int i = n-2; i>=0; i--)
        {
            for(int j=0; j<triangle.get(i).size(); j++)
            {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}


/*
 * Approach 5 - Printing the path of chosen elements
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] path = new int[n][n];
        
        for(int i=n-2; i>=0; i--)
        {
            for(int j=0; j<triangle.get(i).size(); j++)
            {
                int min = triangle.get(i+1).get(j);
                path[i][j] = j;
                if(triangle.get(i+1).get(j) > triangle.get(i+1).get(j+1))
                {
                    min = triangle.get(i+1).get(j+1);
                    path[i][j] = j+1;
                }
                triangle.get(i).set(j,triangle.get(i).get(j) + min);
            }
        }
        System.out.println(Arrays.deepToString(path));
        return triangle.get(0).get(0);
    }
}