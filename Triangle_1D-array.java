TC: O(n*m)
SC: O(n) (n= number of rows)

Runtime: 2 ms, faster than 77.40% of Java online submissions for Triangle.
Memory Usage: 38.8 MB, less than 16.33% of Java online submissions for Triangle.

Approach : Same approach as previous solution. Instead of using List of Lists, we use an 1D-array to calculated the path as only previous
node is needed to calculate the current array values.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    
        if(triangle == null || triangle.size() ==0) return 0;
        int r= triangle.size();
        int[] dp  = new int[r];
        
        
        for(int j=0;j<triangle.get(r-1).size() ;j++){
            dp[j]= triangle.get(r-1).get(j);
        }
       
        System.out.println(Arrays.toString(dp));
        for(int i=r-2; i>=0 ;i--){
            for(int j=0 ; j<=i;j++){
                dp[j] =triangle.get(i).get(j)+ Math.min(dp[j],dp[j+1]);
            }
       
        }
       
        return dp[0];
    }
}
