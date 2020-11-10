//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length==0||A==null||A.length<3)
        {
            return 0;
        }
        int sum=0;
        int prev=0;
        for(int i=A.length-3;i>=0;i--)
        {
            if(A[i+1]-A[i]==A[i+2]-A[i+1])
            {
                prev=prev+1;
                sum+=prev;
            }
            else
            {
                prev=0;
            }
        }
        return sum;
    }
}