//arithmetuc slice

//tc n
//sc 1
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
//         int count = 0;
        int n = nums.length;
        
//         for(int i = 0; i < n - 2; i++){
            
//             int diff = nums[i+1] - nums[i];
            
//             for(int j = i + 2; j < n; j++){
                
//                 if(nums[j] - nums[j-1] == diff){
                    
//                     count++;
//                 }
                
//                 else{
//                     break;
//                 }
                
//             }
            
//         }
//         return count;
        
        int result = 0;
        int count = 0;
        
        for (int i = 2; i < n; i++){
            
            if(nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                
                count++;
                result += count;
            }
            
            else{
                count = 0;
            }
            
        }
        return result;
    }
}

// minimum path sum in a triangle

//tc m*n
//sc 1

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
//        int[][] dp = new int[triangle.size()][];
        
//        for(int i = 0; i < dp.length; i++){
//            dp[i] = new int[i+1];
//            for(int j = 0; j <= i; j++){
//                dp[i][j] = -1;
//            }
//        } 
        
//        int result = helper(triangle, 0, 0, dp);
//        return result;
        
        for(int i = n-2; i >= 0; i--){
            
            for(int j = 0;j<triangle.get(i).size();j++){
               
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col, int[][] dp){
        
        //base
        
        if(row >= triangle.size()) return 0;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        //logic
        
        int total = triangle.get(row).get(col) + Math.min(helper(triangle, row + 1, col, dp), helper(triangle, row + 1, col + 1, dp));
        
        dp[row][col] = total;
        
        return total;
        
    }
    
}
