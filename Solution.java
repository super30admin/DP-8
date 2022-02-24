class Solution {
    //bottom up o(n) time and o(n) space
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;int n = nums.length;
        int []dp = new int[n];
        for(int i = n - 3; i >=0; i--){
            if(nums[i+2]-nums[i+1] == nums[i+1] - nums[i]){
                dp[i] = dp[i+1] + 1;
            }
        }
        for(int i = 0;i < dp.length; i++){
            count += dp[i];
        }
        return count;
    }
}

class Solution {
    //o(m*n) time and constant space
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;

        }
        int n = triangle.size();
        for(int i = n -2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));

            }
        }
        return triangle.get(0).get(0);
    }
}