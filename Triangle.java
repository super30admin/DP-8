//Time complexity: O(m*n), m= number of arraylists, n= number of elements in each arraylist
//Space complexity: O(m*n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> res=new ArrayList<>();
        int m=triangle.size(); int n=triangle.get(0).size();
        List<Integer> f= new ArrayList(); 
        f.add(triangle.get(0).get(0));
        res.add(f);
        for(int i=1;i<m;i++)
        {
            List<Integer> l=new ArrayList(); 
            for(int j=0;j<triangle.get(i).size();j++)
            {
               
                if(j==0)
                {
                    l.add(triangle.get(i).get(j)+res.get(i-1).get(0));
                }
                else if(j==triangle.get(i).size()-1)
                {
                    l.add(triangle.get(i).get(j)+res.get(i-1).get(res.get(i-1).size()-1));

                }
                else
                {
                    l.add(triangle.get(i).get(j)+ Math.min(res.get(i-1).get(j), res.get(i-1).get(j-1)));
                }   
            }
            res.add(l);
        }
        int min=Integer.MAX_VALUE;
        int i=res.size()-1;
        for(int j=0;j<res.get(i).size();j++)
        {
            if(res.get(i).get(j)<min)
                min=res.get(i).get(j);
        }
        return min;
    }
}