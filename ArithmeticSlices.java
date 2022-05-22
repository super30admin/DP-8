import java.util.Arrays;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class ArithmeticSlices { 
	/**Approach1: DP Array | Time O(n) | Space O(n)**/	
	/*public int numberOfArithmeticSlices(int[] nums) {
        int n= nums.length;
        int sum = 0;
        int[] dp = new int[n];
        for(int i=2; i<n; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }*/
	/**Approach2: DP**/	
	public int numberOfArithmeticSlices(int[] nums) {
        int n= nums.length;
        int sum = 0;
        int prev=0; int curr=0;
        for(int i=2; i<n; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                curr = prev + 1;
                sum += curr;
            }else{
                curr = 0;
            }
            prev = curr;
        }
        return sum;
    }
	
        
	// Driver code to test above
	public static void main (String[] args) {	
		ArithmeticSlices ob  = new ArithmeticSlices();			
		int[]nums = {1,2,3,4};
		System.out.println("Total number of arithmetic subarrays are: "+ob.numberOfArithmeticSlices(nums));
	}
}
