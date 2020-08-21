//Time-O(n)
//Space-O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0)
            return 0;
        int n = A.length;
        int[] dp = new int[n];
        int sum = 0;
        for(int i=2;i<n;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
                sum+=dp[i];
            }
        }
        return sum;
    }
}

//Time-O(n)
//Space-O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0)
            return 0;
        int n = A.length;
        int sum = 0;
        int prev = 0;
        for(int i=2;i<n;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                prev+=1;
                sum+=prev;
            }else{
                prev=0;
            }
        }
        return sum;
    }
}
