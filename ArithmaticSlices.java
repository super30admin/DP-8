//time complexity is o(n2)
//space complexity is o(1)
//idea is to take difference between index at 0 and first element and check if difference is same for next pair(first and second index) . if same then count++
// else check the next pair difference. do this process till  input length -2.
// at the end return count
public class ArithmaticSlices {
	//brute force solution
	    int count =0;
	    public int numberOfArithmeticSlices(int[] A) {
	        for(int i =0 ; i<A.length -2 ;i++){
	            int d = A[i+1] - A[i];
	            for(int j = i+2 ;j < A.length ;j++){
	                if(A[j] - A[j-1] ==d){
	                    count++;
	                }else{
	                    break;
	                }
	            }
	        }
	        return count;
	    }
	    
	    // dynamic programming
	          int dp=0;
	          int sum =0;
	    public int numberOfArithmeticSlicesDp(int[] A) {
	        
	        for(int i = 2; i<A.length ; i++){
	            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
	                dp = dp+1;
	                sum+= dp;
	            }else{
	                dp =0;
	            }
	        }
	        return sum;
	    }

	    	   // with o(n) space dp
	        public int numberOfArithmeticSlicesDP2(int[] A) {
	             int[] dp = new int[A.length];
	             int sum = 0;
	             for(int i=2; i< dp.length;i++){
	                 if(A[i]-A[i-1] == A[i-1]-A[i-2]){
	                     dp[i] = 1+dp[i-1];
	                     sum+=dp[i];
	                 }
	             }
	            return sum;
	        }
	    
	
}
