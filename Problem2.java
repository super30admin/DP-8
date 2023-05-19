//Time -> O(n * n)
//Space -> O(n)
public class Problem2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            for(int j = 0; j <= n-1; j++){
                dp[j] = triangle.get(n-1).get(j);
            }
            for(int i = n - 2; i >= 0; i--){
                for(int j = 0; j <= i; j++){
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
                }
            }
            return dp[0];
        }
    }

