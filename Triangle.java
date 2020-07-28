import java.util.List;
//time complexity is o(m*n) m is size of triangle and n is no of elements in list.
//space complexity is o(m) m is size of traingle.
// idea is start from last row and store Minsum array.
//at each row calculate min  between adjacent element and add current triangle value. And update in dp array at current index.
//below diagram shows adjacent values from which we select min value and add to current 
/*  2
   /\
  3 4
 /\ /\
6  5  7
/\ /\ /\
4 1  8 3*/
public class Triangle {
	    public int minimumTotal(List<List<Integer>> triangle) {
	        int rows = triangle.size();
	        int[] dp = new int[rows+1];
	        for(int i = rows -1; i>=0 ; i--){
	            for(int j=0; j<=i;j++){
	                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
	            }
	        }
	        return dp[0];
	    }
	    
	    // constant space dp
	    public int minimumTotal2(List<List<Integer>> triangle) {
	        int rows = triangle.size();
	        int sum =0;
	        for(int i = rows -2; i>=0 ; i--){
	            for(int j=0; j<=i;j++){
	                List<Integer> list = triangle.get(i+1);
	                sum = Math.min(list.get(j),list.get(j+1)) + triangle.get(i).get(j);
	                triangle.get(i).set(j,sum);
	            }
	        }
	        return triangle.get(0).get(0);
	    }
}
