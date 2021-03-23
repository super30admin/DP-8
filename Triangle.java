//Time Complexity: o(n);
//Space Complexity: 0(n)
//Expln: Traverse from the bottom of the triangle by taking the min between 2 elements and adding to the previous levels element
// at corresponding position and store it in dp array in this way we ll only be stroing min and at the end we ll have min in index 0s
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = 0;
        int[] dp = new int[triangle.size()];
        for(int i = 0; i<dp.length; i++)
        {
            dp[i] = triangle.get(dp.length-1).get(i);
        }
        for(int i =dp.length-2; i >= 0; i--)
        {
            for(int j = 0; j <= i; j++){
                dp[j] =  triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}