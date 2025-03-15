//TC: O(N) where N is total number of elements in triangle
//SC: O(n) where n is number of rows in triangle, hence number of elements in last row
//approach: one dimensional dp array, from bottom to top keeping minimums

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            List<Integer> triangleRow = triangle.get(i);
            for(int j=0;j<triangleRow.size();j++){
                if(i==n-1){
                    dp[j] = triangleRow.get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j+1]) + triangleRow.get(j);
                }
            }
        }
        return dp[0];
    }
}
