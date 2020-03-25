//Time Complexity-O(n^2)
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size()==0 || A.size()<3)
        {
            return 0;
        }
        int count=0;
        for(int i=0;i<A.size()-2;i++)
        {
            int a=A[i+1]-A[i];
            for(int j=i+1;j<A.size()-1;j++)
            {
                if(A[j+1]-A[j]==a)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
                
        }
        return count;
    }
};