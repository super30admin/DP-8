class Triangle {
    
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0)
            return 0;

        int n = triangle.size();
        int minVal = triangle.get(0).get(0);
            
//         // TOP-DOWN Approach:
//         for(int i = 1; i < n; i++){
//             minVal = Integer.MAX_VALUE;
//             for(int j = 0; j < triangle.get(i).size(); j++){
//                 int sum = 0;
//                 if(j == 0){
//                     sum = triangle.get(i).get(j) + triangle.get(i-1).get(j);
//                 }else if(j == triangle.get(i).size() - 1){
//                     sum = triangle.get(i).get(j) + triangle.get(i-1).get(triangle.get(i-1).size() - 1);
//                 }else{
//                     int min = Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1));
//                     sum = min + triangle.get(i).get(j);
//                 }
//                 minVal = Math.min(minVal, sum);
//                 triangle.get(i).set(j, sum);
//             }
//         }
//         return minVal;
        
        // BOTTOM UP Approach:
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = triangle.get(n-1).get(i);
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}