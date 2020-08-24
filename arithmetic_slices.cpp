//Time Complexity-O(n^2) and O(n)
//Space Complexity-O(n) and O(1)
//Ran successfully on leetcode

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.empty() || A.size()<3)
            return 0;

        /*int count=0;
        for(int i=0;i<A.size()-2;i++)
        {
            int diff=A[i+1]-A[i];
            for(int j=i+1;j<A.size()-1;j++)
            {
                if(diff==A[j+1]-A[j])
                    count++;
                else
                    break;
            }                
        }
        return count;*/
		
        /*int n=A.size();
        vector<int>dp(n,0);
        int sum=0;
        for(int i=2;i<n;i++)
        {
            if(A[i]-A[i-1]==A[i-1]-A[i-2])
                dp[i]=dp[i-1]+1;
            sum+=dp[i];
        }
        return sum;*/
		
		//DP with only variable
        /*int sum=0;
        int prev=0;
        for(int i=2;i<n;i++)
        {
            if(A[i]-A[i-1]==A[i-1]-A[i-2])
            {
                prev=prev+1;
                sum=sum+prev;
            }
            //We do this prev=0 because dp array was initialized with 0 
            else
                prev=0;
        }
        return sum;*/
    }
};