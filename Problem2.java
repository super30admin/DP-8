import java.util.*;

public class Problem2 {
        
    public int helper(int row, int column, List<List<Integer>> triangle, int[][]dp){
        
        if(row>=triangle.size()||column>=triangle.get(row).size()){
            
            return 0;
        }
        if(dp[row][column]!=-1){return dp[row][column];}
       
        int x= helper(row+1,column,triangle,dp);
        int y=helper(row+1,column+1,triangle,dp);
       return  dp[row][column]=triangle.get(row).get(column) +Math.min(x,y);
    }
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[][] dp=new int [triangle.size()][triangle.get(triangle.size()-1).size()]; 
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                
                dp[i][j]=-1;
            }
        }
        
        return helper(0,0,triangle,dp);
        
    }
}
