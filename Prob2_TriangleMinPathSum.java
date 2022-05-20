
//Without Mutating I/p Triangle
//TC : O(n^2) 
//SC : O(n) // Maintaining 1D array
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        
        int n = triangle.size();
        
        
        int[] dp = new int[n];
        
        for(int i = 0; i< n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){ //or j < triangle.get(i).size()
                 dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                // triangle.get(i).set(j, triangle.get(i).get(j) + 
                //     Math.min( triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1)) );   
            }   // Updating element at index j in index i by adding min of elements at index j and j+1 in (i+1)th row
            
        }
        return dp[0]; // min-sum of triangle will be at 0th index
    }
}







/*
//Without Mutating I/p Triangle with path we selected
//TC : O(n^2) 
//SC : O(n^2) // maintaing 2D array to store indices of elements which are selected in path
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        
        int n = triangle.size();
        int[][] result = new int[n][n];
        
        int[] dp = new int[n];
        
        for(int i = 0; i< n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){ //or j < triangle.get(i).size()
                 dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                
                if(triangle.get(i+1).get(j)  <  triangle.get(i+1).get(j+1) ){
                    result[i][j] = j;
                }else{
                    result[i][j] = j + 1;
                }
                // triangle.get(i).set(j, triangle.get(i).get(j) + 
                //     Math.min( triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1)) );   
            }   // Updating element at index j in index i by adding min of elements at index j and j+1 in (i+1)th row
            
        }
        
        System.out.println(Arrays.deepToString(result));
        return dp[0]; // min-sum of triangle will be at 0th index
    }
}
*/







/*
//Mutating I/p Triangle
//TC : O(n^2) 
//SC : O(1)
//BOTTOM-UP DP Solution
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        
        int n = triangle.size();
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){ //or j < triangle.get(i).size()
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                    Math.min( triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1)) );   
            } // Updating element at index j in index i by adding min of elements at index j and j+1 in (i+1)th row
        }
        
        return triangle.get(0).get(0);
    }
}

*/

/*
//Mutating I/p Triangle


//TC : O(n^2)
//SC : O(1)
//TOP-DOWN DP Solution
//Return min of last list in triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        
        int n = triangle.size();
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){ //or j < triangle.get(i).size()
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) +                                                                 triangle.get(i-1).get(j)  ); //J == 0 HERE
                } else if (j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) +                                                                 triangle.get(i-1).get(j-1)  ); 
                } else { // for the elements except corner elements
                    triangle.get(i).set(j, triangle.get(i).get(j) + 
                    Math.min( triangle.get(i-1).get(j) , triangle.get(i-1).get(j-1)) ); 
                }
                // Updating element at index j in index i by adding min of elements at index j and j-1 in (i-1)th row
            
            }
        }
        
        return Collections.min(triangle.get(n-1));
    }
}
*/