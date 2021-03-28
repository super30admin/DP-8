import java.util.List;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class Triangle {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size() == 0) return 0;//edge case

            //create dp array
            int rows = triangle.size();
            int[] dp = new int[rows + 1];

            //perform dp calculation
            for (int i = rows-1; i >= 0 ; i--) {
                for (int j = 0; j <=i ; j++) {
                    dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                } 
            }
            return dp[0];
        }
    }

}
