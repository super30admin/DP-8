class Solution {//Time and space of O(n)
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length] ;
        //int prev = 0;
        int sum = 0;
        
        for(int i= 2 ; i< A.length ; i++){
            if(A[i] - A[i-1] == A[i-1]-A[i-2]){
                dp[i] = 1 + dp[i-1];
                //prev = prev + 1;
                sum += dp[i];
                //sum+= prev;
            }
        }
        return sum;
    }
}