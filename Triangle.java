class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //base case
        if(triangle == null ||triangle.get(0) == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        
        int dp[] = new int[triangle.size()];
        
        //copying the last list into the dp array
        for(int j = 0; j < triangle.size(); j++){
            dp[j] = triangle.get(triangle.size()-1).get(j);
        }
        
        //doing computations in reverse direction
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
}

//Time Complexity: O(n) n-> total number of elements
//Space Complexity: O(t) t-> size(triangle)