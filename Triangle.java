import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time O(N^2)
// Space O(N^2)

public class Triangle {
	int [][] dp;
    List<Integer> path;
   public int minimumTotal(List<List<Integer>> triangle) {
       int size = triangle.size();
       path = new ArrayList<>();
       dp = new int[triangle.size()][triangle.size()];
       Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
   
       int result= helper(0,0,triangle);
       for(int val:path){
               System.out.println(val);
       }
       return result;
       
   }
   private int helper(int row, int pos, List<List<Integer>> triangle){
      
      if (row+1 >= triangle.size()){
           dp[row][pos]= triangle.get(row).get(pos);
           return dp[row][pos];
      } 
       if(dp[row][pos]!=Integer.MAX_VALUE)
       return dp[row][pos];
       else{
           dp[row][pos] = triangle.get(row).get(pos) + Math.min (helper(row+1, pos,triangle), helper(row+1, pos+1, triangle));
         
           return dp[row][pos];
       } 

   }
}
