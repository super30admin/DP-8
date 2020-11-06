// Arithmetic Slices
// Time Complexity: O(n) where n = length of array
// Space Complexity: O(n) extra space for dp array

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // base condition
        if (A == null || A.length <= 2) {
            return 0;
        }
        
        // initialize dp array
        int[] dp = new int[A.length];
        
        for (int i=2; i<A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        int output = 0;
        for (int num : dp) {
            output += num;
        }
        
        return output;
    }
}

// Triangle
// Time Complexity: O(n * m) where n = number of rows, m = number of elements in last row
// Space Complexity: O(m) extra space for dp array

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // base condition
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        
        // get last row size
        int size = triangle.get(triangle.size() - 1).size();
        // initializing dp array
        int[] dp = new int[size];
        
        for (int j=0; j<size; j++) {
            dp[j] = triangle.get(size - 1).get(j);
        }
        
        // performing dp
        for (int i=size-2; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
}
