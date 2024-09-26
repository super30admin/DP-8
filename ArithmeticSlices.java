
public class ArithmeticSlices {
	
	//Time Complexity: O(n^2)
	//Space Complexity: O(1)
	class BruteForceSolution {
	    public int numberOfArithmeticSlices(int[] A) {
	        if(A == null || A.length == 0) return 0;
	        int count = 0;
	        int n = A.length;
	        for(int i = 0; i < n - 2; i++){
	            int diff = A[i + 1] - A[i];
	            for(int j = i + 1; j < n - 1; j++){
	                if(A[j + 1] - A[j] == diff){
	                    count++;
	                } else break;
	            }
	        }
	        return count;
	    }
	}
	
	//Time Complexity: O(n)
	//Space Complexity: O(n)
	class DPSolution {
	    public int numberOfArithmeticSlices(int[] A) {
	        if(A == null || A.length == 0) return 0;
	        int sum = 0;
	        int n = A.length;
	        int[] dp = new int[n];
	        for(int i = n - 3; i >= 0; i--){
	            if(A[i + 2] - A[i + 1] == A[i + 1] - A[i]){
	                dp[i] = dp[i + 1] + 1;
	                sum += dp[i];
	            }
	        }
	        return sum;
	    }
	}
	
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	class OptimizedDPSolution {
	    public int numberOfArithmeticSlices(int[] A) {
	        if(A == null || A.length == 0) return 0;
	        int sum = 0;
	        int n = A.length;
	        int curr = 0; int right = 0;
	        for(int i = n - 3; i >= 0; i--){
	            if(A[i + 2] - A[i + 1] == A[i + 1] - A[i]){
	                curr = right + 1;
	                sum += curr;
	                right = curr;
	            } else {
	                right = 0;
	            }
	        }
	        return sum;
	    }
	}
}
