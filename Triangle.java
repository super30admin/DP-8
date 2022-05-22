//Mutating matrix in bottom up manner

//TC: O(n*m) where n is no. of lists in traingle and m is no. of elements in each list
//SC: O(1)

//CODE:
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //null case
         if(triangle ==null || triangle.size() ==0 || triangle.get(0).size() == 0){
             return 0;
         }
        int n= triangle.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j, triangle.get(i).get(j) +
                    Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

//Mutating matrix in top down manner

//TC: O(n*m) where n is no. of lists in traingle and m is no. of elements in each list
//SC: O(1)

//CODE:
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //null case
         if(triangle ==null || triangle.size() ==0 || triangle.get(0).size() == 0){
             return 0;
         }
        int n= triangle.size();
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }else if(j==i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }else{
                 triangle.get(i).set(j, triangle.get(i).get(j) +
                    Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));   
                }
            }
        }
        int min = Collections.min(triangle.get(n-1));
        return min;
    }
}

//Without mutating matrix in bottom up manner
//TC: O(n*m) where n is no. of lists in traingle and m is no. of elements in each list
//SC: O(n)

//Code

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //null case
         if(triangle ==null || triangle.size() ==0 || triangle.get(0).size() == 0){
             return 0;
         }
        int n= triangle.size();
        int[] dp = new int[n];
        for(int j=0;j<n;j++){
            dp[j]= triangle.get(n-1).get(j);   //filling dp array with last list elements
        }
        for(int i=n-2 ;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}

//getting path in bottom up manner with mutating
//TC: O(n*m)
//SC:O(n*m) for path matrix

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //null case
         if(triangle ==null || triangle.size() ==0 || triangle.get(0).size() == 0){
             return 0;
         }
        int n= triangle.size();
        int[][] path = new int[n][n];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j, triangle.get(i).get(j) +
                    Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            
                    //filing path matrix
            if(triangle.get(i+1).get(j) < triangle.get(i+1).get(j+1)){
                path[i][j] = j;
            }else{
                path[i][j] = j+1;
            }
            }
            
        }
        System.out.println(Arrays.deepToString(path));
        return triangle.get(0).get(0);
    }
}

