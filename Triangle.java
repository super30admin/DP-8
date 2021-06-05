//Bottom up with extra space
//Time Complexity : O(n) //number of elements. Also everything is in a list its not n^2 but n
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int n = triangle.size();
        int dp[] = new int[n];
        //copy elemets from last row into dp array
        for(int i=0;i<n;i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        //start iterating from last but one row
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                //keep updating the intermediate result into the dp array
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        //At the end, the final result will be in the first index
        return dp[0];
    }
}
//bottom up approach inplace
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int n = triangle.size();
        //start from last but one row
        for(int i=n-2;i>=0;i--){
            //to access the element from current row
            //j<=i gives the index of the current row
            for(int j=0;j<=i;j++){
                //get the value min value from the next row and add it with current element
                int sum = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                //update the current element with the calculated sum
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
//Top Down approach
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int n = triangle.size();
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                //when the current element is the first element there is only one option to add from the above row's first element
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i-1).get(0)+triangle.get(i).get(0));
                }
                //when the current element is the last element in the current row, the only option to add from is the from above row's last element
                else if(i==j){
                    triangle.get(i).set(j,triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
                }
                //otherwise the element is somewhere in the middle. So the min of col j and j-1 should be considered from the previous row to be added
                else{
                    triangle.get(i).set(j,triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1)));
                }
            }
        }
        //get the min value from the last row which has the final result
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, triangle.get(n-1).get(i));
        }
        return min;
    }
}