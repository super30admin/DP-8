// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //edge case
        if(A == null || A.length<3)
            return 0;
        int count = 0;
        
        for(int i=0; i<A.length-2; i++) // i goes till 3 places less
        {
            for(int j=i+1; j<A.length-1; j++) // j goes till 2 places less
            {
                if(A[j+1]-A[j] == A[i+1]-A[i]) // if diff found at i is same at that found at j
                    count++; // we increase count
                else 
                    break; // can't find any further continous sequence so break
            }
        }
        
        return count;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //edge case
        if(A == null || A.length<3)
            return 0;
        int count = 0;
        int dp[] = new int[A.length]; // to store the number of slices till the point so that we can reuse that value
       for(int i=A.length-3;i>=0;i--) // running from back
       {
           if(A[i+1] - A[i] == A[i+2]- A[i+1]) // if we have same diff i.e it is a pair
           {
               dp[i] = dp[i+1]+1; // take the prev pairs of same diff and add one 
               count += dp[i]; // add to the count the number of pairs till the point
           }
       }
        return count;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //edge case
        if(A == null || A.length<3)
            return 0;
        int count = 0;
        int prev = 0; // store the possible combinations of diff till now
       for(int i=A.length-3;i>=0;i--)
       {
           if(A[i+1] - A[i] == A[i+2]- A[i+1]) // if we have the same diff
           {
               prev = prev+1; // increase prev
               count += prev; // add to count
           }
           else
           {
               prev = 0; // reset prev as no pair possible for the diff
           }
       }
        return count; 
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //edge case
        if(triangle == null || triangle.size() == 0)
            return 0;
        int n = triangle.size();
        
        for(int i=n-2;i>=0;i--) // starting from last second row
        {
            for(int j=0; j<triangle.get(i).size(); j++) // for all elements of ith row
            {
                
                triangle.get(i).set(j, triangle.get(i).get(j) +
                                    Math.min(triangle.get(i+1).get(j),
                                  triangle.get(i+1).get(j+1))); // get the min value from the row below from j and j+1 index and add
            }
        }
        
        return triangle.get(0).get(0); // first value
        
    }
}