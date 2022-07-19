// Time: O(MN) | Space: O(N)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // please ignore this as it is not a part of the ask
        int [][] path = new int[n][n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            // we keep filling in the dp array with the last row values
            dp[i] = triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                int curr =  triangle.get(i).get(j);
                int choice1 = curr+dp[j];
                int choice2 = curr+dp[j+1];
                // we have two choices at every element
                // whichever is minimum amongst them, we pick it
                if(choice1 < choice2)
                    path[i+1][j] = j;
                else path[i+1][j] = j+1;
                dp[j] = triangle.get(i).get(j)+Math.min(dp[j], dp[j+1]);
            }
        }
        //additional thing, we are returning the path as well
        // for this input [[2],[3,4],[6,5,7],[4,1,8,3]]
        // this is the path [[0, 0, 0, 0], [0, 0, 0, 0], [1, 1, 0, 0], [1, 1, 3, 0]]
        System.out.println(Arrays.deepToString(path));
        return dp[0];
    }
}

// Time: O(MN) | Space: O(1) since we are mutating the same given input

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-2;i>=0;i--) {
            System.out.println(i);
            for(int j=0;j<=i;j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}