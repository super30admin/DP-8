class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo=new int[triangle.size()][triangle.size()];
        for(int[] row:memo){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        return helper(triangle,0,0,memo);
       
    }

    private int helper(List<List<Integer>> triangle,int r,int c,int[][] memo)
    {
        if(r==triangle.size()){
            return 0;
        }

        if(memo[r][c]!=Integer.MAX_VALUE)
        {
            return memo[r][c];
        }

        int left=helper(triangle,r+1,c,memo);
        int right=helper(triangle,r+1,c+1,memo);
        memo[r][c]=triangle.get(r).get(c)+Math.min(left,right);
        return memo[r][c];
    }



}