//using dp array
//TC: O(n)
//SC: O(n)


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        
        int [] dp = new int[triangle.size()];
        
        //last row
        for(int i =0; i < dp.length; i++){
            dp[i] = triangle.get(dp.length - 1).get(i);
        }
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

//without using dp array
//TC: O(n)
//SC: O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        
        for(int i = triangle.size() - 2; i>=0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
        
    }
}
