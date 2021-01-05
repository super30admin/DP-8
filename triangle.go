// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
start from second last row and reduce to 1st row
for each element in row current element += min(triangle of i+1,j and i+1,j+1 )
return triangle of 0,0
*/
package main

import "fmt"

//O(n) O(1)
func minimumTotal(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}
	//bottom up dp
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
		}
	}
	return triangle[0][0]

	//top down dp
	/*for i:=1;i<len(triangle);i++ {
	      for j:=0;j<len(triangle[i]);j++ {
	          minv := 100000
	          if j-1 >=0 {
	              minv = min(minv, triangle[i-1][j-1])
	          }
	          if j < len(triangle[i-1]) {
	              minv = min(minv, triangle[i-1][j])
	          }
	          triangle[i][j] += minv
	      }
	  }
	  res := 100000
	  for i:=0;i<len(triangle);i++ {
	      res = min(res, triangle[len(triangle) - 1][i])
	  }
	  return res*/
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func MainTriangle() {
	fmt.Println(minimumTotal([][]int{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}})) //expected 11
}
