// // Bottom up DP TC = O(n^2) using extra matrix as input cannot be mutated
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size(); // number of rows in matrix
//         int[][] dp = new int[n][n]; //forming an nxn matrix as input cannot be mutated
//         // Fill the last row of the dp matrix same as input row
//         for(int i=0;i<n;i++){
//             dp[n-1][i] = triangle.get(n-1).get(i);
//         }
//         for(int i=n-2;i>=0;i--){ //start from secondlast row as last row of dp matrix already filled
//             // for(int j=0;j<triangle.get(i).size();j++){ use either this or below one
//             for(int j=0;j<=i;j++){ //don't include last element as for each 'i' we check current j and next j // we did j<=i as every row has i elements 
//                 dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
//             }
//         }
//         return dp[0][0];
//     }
// }
//  ##########################################################################
// // Bottom up DP TC = O(n^2) using extra array as input cannot be mutated
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size(); // number of rows in matrix
//         int[] dp = new int[n]; //forming an nxn matrix as input cannot be mutated
//         // Fill the last row of the dp matrix same as input row
//         for(int i=0;i<n;i++){
//             dp[i] = triangle.get(n-1).get(i);
//         }
//         for(int i=n-2;i>=0;i--){ //start from secondlast row as last row of dp matrix already filled
//             // for(int j=0;j<triangle.get(i).size();j++){ use either this or below one
//             for(int j=0;j<=i;j++){ //don't include last element as for each 'i' we check current j and next j // we did j<=i as every row has i elements 
//                 dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
//             }
//         }
//         return dp[0];
//     }
// }
//  ##########################################################################
// Bottom up DP TC = O(n^2) using extra array as input cannot be mutated ALso finding all the paths it took
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size(); // number of rows in matrix
//         int[] dp = new int[n]; //forming an nxn matrix as input cannot be mutated
//         int[][] path = new int[n][n];
//         // Fill the last row of the dp matrix same as input row
//         for(int i=0;i<n;i++){
//             dp[i] = triangle.get(n-1).get(i);
//         }
//         for(int i=n-2;i>=0;i--){ //start from secondlast row as last row of dp matrix already filled        
//             // for(int j=0;j<triangle.get(i).size();j++){ use either this or below one
//             for(int j=0;j<=i;j++){ //don't include last element as for each 'i' we check current j and next j // we did j<=i as every row has i elements
//                 if(dp[j]<dp[j+1]){
//                     path[i][j] = j;
//                     dp[j] = triangle.get(i).get(j) + dp[j];    
//                 }else{
//                     path[i][j] = j+1;
//                     dp[j] = triangle.get(i).get(j) + dp[j+1];
//                 } 
//             }
//         }
//         System.out.println(Arrays.deepToString(path));
//         return dp[0];
//     }
// }
//  ##########################################################################

// Bottom up DP from top -- TC = O(n^2) using extra matrix as input cannot be mutated ALso finding all the paths it took
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n]; 
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){ 
            for(int j=0;j<=i;j++){ 
                if(j==i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }else if(j==0){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                }else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }              
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}
//  ##########################################################################