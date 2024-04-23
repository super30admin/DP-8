package week12.day6;
//TC - O(m*n)
//SC - O(m*n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(m*n)
//SC - O(m*n)
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.get(triangle.size() - 1).size();
      int[][] dp = new int[n][n];
      for (int i = n-1; i >= 0; i--) {
          for (int j = i; j >= 0; j--) {
          	if(i==n-1) {
          		dp[i][j] = triangle.get(i).get(j);
          		continue;
          	}
              int curr = triangle.get(i).get(j); 
              int a = dp[i+1][j]; 
              int b = dp[i+1][j+1];
              dp[i][j] = Math.min(curr+a, curr+b);
              
          }
      }
      return dp[0][0];
  }
}
}
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        
        Solution s = new Solution();
        System.out.println(s.minimumTotal(triangle));
	}

}
