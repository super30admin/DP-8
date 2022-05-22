import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Time Complexity : O(n^2)
//Space Complexity : O(1)
public class TriangleMinPathSum {	
	/**Approach2: Without mutating the matrix + Bottom up | Time O(n^2) | Space O(n)**/
	/*public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[] dp = new int[n];        
        for(int i=n-1; i>=0;i--){
            for(int j=0; j<=i; j++){ 
                //Initialze dp array with last row
                if(i == n-1){
                    dp[j] = triangle.get(i).get(j);
                }//process other rows
                else{
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }                
            }
        }
        return dp[0];
    }*/
	
	/**Approach1: Mutating the matrix + Bottom up | Time O(n^2) | Space O(1)**/	
	public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        for(int i=n-2; i>=0;i--){
            for(int j=0; j<=i; j++){                
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));                
            }
        }        
        return triangle.get(0).get(0);
    }
	
	
	// Driver code to test above
	public static void main (String[] args) {
		TriangleMinPathSum ob = new TriangleMinPathSum();
		Integer[][] array= {{2},{3,4},{6,5,7},{4,1,8,3}};
		List list= new ArrayList<>();
		for(Integer[] arr: array) {
			list.add(Arrays.asList(arr));
		}
			
		System.out.println("Min Path Sum of Triangle: "+ob.minimumTotal(list));	
		
	}
}
