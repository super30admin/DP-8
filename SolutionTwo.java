// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0)
            return 0;

        List<Integer> path = new ArrayList<Integer>();
        int n = triangle.size();



        for(int i=1;i<n;i++)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int min = Integer.MAX_VALUE;

                if(j-1>=0 && j-1 < triangle.get(i-1).size())
                {
                    min = Math.min(min,triangle.get(i-1).get(j-1));
                }
                if(j>=0 && j<triangle.get(i-1).size())
                {
                    min = Math.min(min,triangle.get(i-1).get(j));
                }

                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }

        int result = Integer.MAX_VALUE;

        for(int j=0;j<triangle.get(n-1).size();j++)
        {
            result = Math.min(result,triangle.get(n-1).get(j));
        }

        return result;
    }
}