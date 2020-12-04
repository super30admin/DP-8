// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain dp arraylist of same size as triangle, min path sum to get to last row is min over items in row (cost to get to that element)
// dp[i][j] = min(dp[i-1][j-1], dp[i-1][j])
// minCost = min(dp[last row][:])

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        List<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        
        for(List<Integer> row : triangle){
            ArrayList<Integer> r = new ArrayList<Integer>(Collections.nCopies(row.size(), 0));
            dp.add(r);   
        }
        
        dp.get(0).set(0, triangle.get(0).get(0));
        
        for(int i=1; i<dp.size(); i++){
            for(int j=0; j<dp.get(i).size(); j++){
                int l = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                if(j-1>=0)
                    l = dp.get(i-1).get(j-1);
            
                if(j<dp.get(i-1).size())
                    r = dp.get(i-1).get(j);
                
                int val = Math.min(l, r) + triangle.get(i).get(j);
                dp.get(i).set(j, val);    
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<dp.get(dp.size()-1).size(); i++){
            min = Math.min(dp.get(dp.size()-1).get(i), min);
        }
        
        return min;
    } 
}