//Brute Force: All possible combination of contiguous subarray-O(n^2)
// Time: O(n^2) n-length of the input array A
// Space: O(1)
// class Solution {
//     public int numberOfArithmeticSlices(int[] A) {
//         if(A== null || A.length < 3) return 0;

//         int cnt = 0;
//         for(int i=0;i<A.length-2;i++){
//             int diff = A[i+1]-A[i];
//             for(int j=i+1;j<A.length-1;j++){
//                 if(A[j+1]-A[j] == diff)
//                     cnt++;
//                 else
//                     break;
//             }
//         }
//         return cnt;
//     }
// }

// Dynmic Programming: In brute force approach- there are repeated pblms like 12345 and again 2345 and 345 - hence trying to optimize the algo by avoiding repeated pblms
// Time: O(n) n-length of the input array
// Space: O(n)
//
// class Solution {
//     public int numberOfArithmeticSlices(int[] A) {
//         if(A== null || A.length < 3) return 0;

//         int[] dp = new int[A.length];
//         if(A[1]-A[0] == A[2]-A[1]) dp[2] = 1;
//         for(int i=3;i<A.length;i++){
//             if(A[i] - A[i-1] == A[i-1]-A[i-2])
//                 dp[i] = dp[i-1]+1;
//         }
//         int cnt = 0;
//         for(int i=0;i<dp.length;i++)
//             cnt+= dp[i];

//         return cnt;
//     }
// }

// Optimized dp using one single variable- same logic as DP
// Time: O(n) n-length of the input array A
// Space: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A== null || A.length < 3) return 0;

        int prev = 0,sum=0;
        if(A[1]-A[0] == A[2]-A[1]) prev = 1;
        sum = prev;
        for(int i=3;i<A.length;i++){
            if(A[i] - A[i-1] == A[i-1]-A[i-2])
            {
                prev = prev+1;
                sum += prev;
            }else
                prev = 0;
        }

        return sum;
    }
}