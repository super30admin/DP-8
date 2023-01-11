Problem 120-Triangle
TC,SC-O(m*n)
 Solution-
  
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>(); 
        temp1.add(triangle.get(0).get(0));
        result.add(temp1);
        for(int i =1;i<triangle.size();i++)
        {   ArrayList<Integer> temp = new ArrayList<>(); 
            for(int j=0;j<triangle.get(i).size();j++)
            {
                if(j==0)
                {
                    temp.add(triangle.get(i).get(j) + result.get(i-1).get(j));
                    
                }
              else  if(j==triangle.get(i).size()-1)
                {
                    temp.add(triangle.get(i).get(j)+result.get(i-1).get(j-1));
                }
                else
                {
                    int min = Math.min(result.get(i-1).get(j-1), result.get(i-1).get(j));
                    temp.add(triangle.get(i).get(j)+min);
                   
                }
            }
                result.add(temp);
                
            }
         
         int end = result.size()-1;
         int ans = Integer.MAX_VALUE;
         for(Integer t : result.get(end))
         {
             ans = Math.min(ans,t);
         }
        
         return ans;
         
        
    }
}
