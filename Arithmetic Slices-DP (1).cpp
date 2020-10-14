//Time Complexity-O(n)-->'n' is size of input vector.
//Space Complexity-O(n)
//Did the code run on Leetcode? Yes

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size()==0 || A.size()<3)
        {
            return 0;
        }
        int count=0;
        vector<int>dp(A.size(),0);
        for(int i=2;i<A.size();i++)
        {
            if(A[i-1]-A[i-2]==A[i]-A[i-1])
            {
                dp[i]=dp[i-1]+1;
                count+=dp[i];
            }
        }
        return count;
    }
};