// ******************** Bottom Up Approach ********************

// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         for(int i=n-2; i>=0; i--) {
//             List<Integer> list = triangle.get(i);
//             List<Integer> nextList = triangle.get(i+1);
//             for(int j=0; j<list.size(); j++) {
//                 list.set(j, list.get(j) + Math.min(nextList.get(j), nextList.get(j+1)));
//             }
//         }
//         return triangle.get(0).get(0);
//     }
// }




// // ******************** Top Down Approach ********************

// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         for(int i=1; i<n; i++) {
//             for(int j=0; j<=i; j++) {
//                 if(j==0) 
//                     triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
//                 else if(j==i)
//                     triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
//                 else
//                     triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
//             }
//         }
//         int min = Integer.MAX_VALUE;
//         for(int j=0; j<n; j++) {
//             min = Math.min(min, triangle.get(n-1).get(j));
//         }
//         return min;
//     }
// }
