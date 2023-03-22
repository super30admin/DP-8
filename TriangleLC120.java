class Solution {

    //Approach 7, bottom up apparoach, starting from the bottom
    //Time Complexity: O(n*n)
    //Space Complexity: O(1)

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0) return 0;                      //check for null case

        int n = triangle.size();                                                    //get the size
        
        for(int i=n-2; i>=0; i--){                                                  //iterate from the second last row to the starting row
            for(int j=0; j<=i; j++){                                                //iterate to the column

                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));        //get the minimum value from j and j+1 column, add the current cell value and set it to the current cell value
            }
        }
        return triangle.get(0).get(0);                                              //return the first row first column value
    }

    
    
    //Approach 6, bottom up apparoach, starting from the bottom, also we have to return the path as well
    //Time Complexity: O(n*n)
    //Space Complexity: O(1)
     
    // public int minimumTotal(List<List<Integer>> triangle) {

    //     if(triangle == null || triangle.size() == 0) return 0;

    //     int n = triangle.size();
    //     int[][] path = new int[n][n];
        
    //     for(int i=n-2; i>=0; i--){
    //         for(int j=0; j<=i; j++){

    //             int min = triangle.get(i+1).get(j);
    //             path[i][j] = j;

    //             if(triangle.get(i+1).get(j) > triangle.get(i+1).get(j+1)){
    //                 min = triangle.get(i+1).get(j+1);
    //                 path[i][j] = j+1;
    //             }

    //             triangle.get(i).set(j, triangle.get(i).get(j) + min);
    //         }
    //     }
    //     System.out.println(Arrays.deepToString(path));
    //     return triangle.get(0).get(0);
    // }




    //Approach 5, bottom up apparoach, starting from top
    //Time Complexity: O(n*n)
    //Space Complexity: O(1)

    // public int minimumTotal(List<List<Integer>> triangle) {

    //     if(triangle == null || triangle.size() == 0) return 0;

    //     int n = triangle.size();
        
    //     for(int i=1; i<n; i++){
    //         for(int j=0; j<=i; j++){

    //             if(j==0){
    //                 triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
    //             }
    //             else if(j==i){
    //                 triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
    //             }
    //             else{
    //                 triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
    //             }
    //         }
    //     }
    //     int min = Integer.MAX_VALUE;

    //     for(int j=0; j<n; j++){
    //         min = Math.min(min, triangle.get(n-1).get(j));
    //     }
    //     return min;
    // }




    //Approach 4, if we are not supposed to mutate the triangle list
    //Time Complexity: O(n*n)
    //Space Complexity: O(n)

    // public int minimumTotal(List<List<Integer>> triangle) {

    //     if(triangle == null || triangle.size() == 0) return 0;

    //     int n = triangle.size();

    //     int[] dp = new int[n];

    //     for(int j=0; j<n; j++){
    //         dp[j] = triangle.get(n-1).get(j);
    //     }

    //     for(int i=n-2; i>=0; i--){
    //         for(int j=0; j<=i; j++){

    //             dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                
    //         }
    //     }
    //     return dp[0];
    // }




    //Approach 3, if we are not supposed to mutate the triangle list
    //Time Complexity: O(n*n)
    //Space Complexity: O(n*n)

    // public int minimumTotal(List<List<Integer>> triangle) {

    //     if(triangle == null || triangle.size() == 0) return 0;

    //     int n = triangle.size();

    //     int[][] dp = new int[n][n];

    //     for(int j=0; j<n; j++){
    //         dp[n-1][j] = triangle.get(n-1).get(j);
    //     }

    //     for(int i=n-2; i>=0; i--){
    //         for(int j=0; j<=i; j++){

    //             dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                
    //         }
    //     }
    //     return dp[0][0];
    // }



    
    //Approach 2, Top Down Approach
    //Time Complexity : O(m*m)
    //Space Complexity: O(m*m) + O(m) recursive stack
    //dp defination dp[i,j] => minimumTotal to reach the end of row starting from ith row and jth column

//     public int minimumTotal(List<List<Integer>> triangle) {
     
//         int m = triangle.size();
//         int[][] dp = new int[m][];
        
//         for(int i=0; i<m; i++){
//             dp[i]= new int[i+1];
//             Arrays.fill(dp[i], Integer.MIN_VALUE);
//         }
        
//         return minimumTotal(triangle, 0, 0, dp);
//     }
    
//     public int minimumTotal(List<List<Integer>> triangle, int i, int j, int[][] dp){
        
//         if(i == dp.length || j == dp[i].length){
//             return 0;
//         }
        
//         if(dp[i][j] == Integer.MIN_VALUE){
            
//             dp[i][j] = triangle.get(i).get(j) + Math.min(
             
//                 minimumTotal(triangle, i+1, j, dp),
//                 minimumTotal(triangle, i+1, j+1, dp)
//             );
            
//         }
        
//         return dp[i][j];
//     }
    
    
    
    //Approach 1, Bottom Up Approach (Starting from the top)
    //Time Complexity : O(m*m)
    //Space Complexity: O(1)
    //dp defination dp[i,j] => minimumTotal to reach the end of row starting from ith row and jth column
    
    // public int minimumTotal(List<List<Integer>> triangle) {
     
    //     int m = triangle.size();
        
    //     for(int i=1; i<m ; i++){
            
    //         List<Integer> prev = triangle.get(i-1);
    //         List<Integer> current = triangle.get(i);
    //         int currSize = current.size();
            
    //         //0th element
    //         current.set(0, current.get(0)+ prev.get(0));
            
    //         //middle elements
            
    //         for(int j=1; j<currSize-1; j++){
                
    //             int a = prev.get(j-1);
    //             int b = prev.get(j);
    //             int currentCost = current.get(j);
    //             current.set(j, currentCost + Math.min(a,b));
            
    //         }
            
    //         //last element
    //         current.set(currSize-1, current.get(currSize-1) + prev.get(currSize - 2));  
    //     }
        
    //     int min = Integer.MAX_VALUE;
        
    //     for(int ele: triangle.get(m-1)){
    //         min = Math.min(ele, min);
    //     }
    //     return min;  
    // } 
}
