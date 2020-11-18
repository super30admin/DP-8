//Time Complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: yes

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for(int i=2; i<A.length; i++){
            if(A[i-1]-A[i-2]==A[i]-A[i-1]){
                dp[i] = 1+dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
