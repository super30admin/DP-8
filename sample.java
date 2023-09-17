Problem 1 Arithmetic Slices
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        //dp
        //O(n^2)
        // int[] dp= new int[n];
        // Arrays.fill(dp, 1);
        // int res=1;
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             dp[i]=Math.max(dp[i], dp[j]+1);
        //             res=Math.max(res, dp[i]);
        //         }
        //     }
        // }
        // return res;

        //Binary Search //O(nlogn) O(n)
        int[] arr= new int[n];
        int res=0;
        arr[0]=nums[0];
        int len=1;

        for(int i=1;i<n;i++){
            if(nums[i]>arr[len-1]){
                arr[len]=nums[i];
                len++;
            }else if(nums[i]<arr[len-1]){
                //replace number just greater than nums[i] in arr
                int bsIdx= binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIdx]=nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}

Problem 2 Minimum path in Triangle
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Can be done in multiple ways
//Bottom UP DP-> search for each possible sum for a number and select minimum from it. then go above and again do the same until u reach at top of row. then return min from top of row,
class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        // return dfs(triangle, 0, 0);
        this.dp=new int[n][n];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++)
        //         dp[i][j]=Integer.MAX_VALUE;
        // }
        // return dfs(triangle, 0, 0);

        //bottom up dp
        // for(int i=1;i<n;i++){

        //     for(int j=0;j<=i;j++){
        //         if(j==0){
        //             triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
        //         }else if(j==i){
        //             triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
        //         }else{
        //             triangle.get(i).set(j,triangle.get(i).get(j)
        //             + Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
        //         }
        //     }
        // }
        // int min=Integer.MAX_VALUE;
        //     for(int j=0;j<n;j++){
        //         min=Math.min(min, triangle.get(n-1).get(j));
        //     }
        //     return min;


        //top down dp

        // for(int i=n-2;i>=0;i--){
        //     for(int j=0;j<=i;j++){
        //         triangle.get(i).set(j, triangle.get(i).get(j)+ Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        //     }
        // }
        // return triangle.get(0).get(0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col){
        //base
        // if(row==triangle.size()) return 0;
        //logic
        // int case1= dfs(triangle, row+1, col);
        // int case2= dfs(triangle, row+1, col+1);

        // return Math.min(case1, case2)+ triangle.get(row).get(col);
        int case1= 0,case2=0;
        if(row+1<triangle.size()){
            if(dp[row+1][col]==Integer.MAX_VALUE){
                dp[row+1][col]= dfs(triangle, row+1, col);
            }
            case1= dp[row+1][col];

            if(dp[row+1][col+1]==Integer.MAX_VALUE){
                dp[row+1][col+1]= dfs(triangle, row+1, col+1);
            }
            case2= dfs(triangle, row+1, col+1);
        }

        return Math.min(case1, case2)+ triangle.get(row).get(col);
    }
}