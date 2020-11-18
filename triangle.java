//Time Complexity: O(n) n is total number of nodes
//Space Complexity: O(m) is size of list
//Did it run on leetcode: yes
//Approach: Bottom up approach


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size()];
        int min = 0;
        int n = triangle.size();
        List<Integer> currList = triangle.get(n-1);
        for(int i=0; i<currList.size(); i++){
            dp[i] = currList.get(i);
        }
        
        for(int i=n-2; i>=0; i--){
            currList = triangle.get(i);
            for(int j=0; j<currList.size(); j++){
                dp[j] = currList.get(j) + Math.min(dp[j], dp[j+1]); 
            }
        }
        
        return dp[0];
    }
}
