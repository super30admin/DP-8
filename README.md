# DP-8

## Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

//Time Complexity = O(N)
//Space Complexity = O(1)

class Solution {
public int numberOfArithmeticSlices(int[] nums) {
if(nums == null || nums.length == 0) {
return 0;
}
int result = 0;
int current = 0;
int prev = 0;
for(int i = 2; i < nums.length; i++) {
if(nums[i-1] - nums[i-2] == nums[i]- nums[i-1]) {
current = prev + 1;
result += current;
prev = current;
} else {
prev = 0;
}
}
return result;
}
}

## Problem 2 Triangle (https://leetcode.com/problems/triangle/)

//Time Complexity = O(N\*N)
//Space Complexity = O(1)

class Solution {
public int minimumTotal(List<List<Integer>> triangle) {
if(triangle.size() == 0 || triangle == null) {
return 0;
}
int n = triangle.size();
for(int i = n-2; i >= 0; i--) {
for(int j = 0; j <= i; j++) {
triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
}
}
return triangle.get(0).get(0);
}
}
