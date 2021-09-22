// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //bottom up approach using single array
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle==null|| triangle.size()==0)
            return 0;
        
        int n=triangle.size();
        int[] dp=new int[n];
        
        //last row
        for(int i=0;i<n;i++)
        {
            dp[i]=triangle.get(n-1).get(i);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        
        return dp[0];
    }
    
    // bottom up approach mutating same array
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle==null|| triangle.size()==0)
            return 0;
        
        int n=triangle.size();
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
    
    // top down approach mutating same array
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle==null|| triangle.size()==0)
            return 0;
        
        int n=triangle.size();
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
               if(j==0)
               {
                   triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
               }
                else if(j==i)
                {
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                }
                else
                {
                   triangle.get(i).set(j,triangle.get(i).get(j)+ Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1))); 
                }
                
            }
        }
        
        int min=Integer.MAX_VALUE;
        
        for(int k: traingle.get(n-1))
        {
            min=Math.min(k,min);
        }
        
        return min;
    }
    
}