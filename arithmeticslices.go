// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set total, prev, curr to 0
from i =2 loop over elements
if current-previous element == difference of previous 2 elements then
set curr to prev+1
total to total+curr
prev=curr
else
set prev to 0

return total
*/
package main

import "fmt"

func numberOfArithmeticSlices(A []int) int {
	if len(A) < 3 {
		return 0
	}
	//O(n)O(n) dp
	//dp := make([]int, len(A))
	//sum := 0
	//O(n)O(1) dp not extra space
	total := 0
	prev := 0
	curr := 0
	for i := 2; i < len(A); i++ {
		if A[i]-A[i-1] == A[i-1]-A[i-2] {
			curr = prev + 1
			total += curr
			prev = curr
			//dp[i] = dp[i-1] + 1
			//sum += dp[i]
			//}
		} else {
			prev = 0
		}
	}
	return total
	//return sum
	//O(n2)O(1) sliding window
	/*count := 0
	  for i:=0;i<len(A) - 2;i++ {
	      diff := A[i+1] - A[i]
	      for j:=i+1;j<len(A)-1;j++ {
	          if A[j+1] - A[j] == diff {
	              count++
	          } else {
	              break
	          }
	      }
	  }
	  return count*/
}

func MainArithmeticSlices() {
	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3, 4})) //expected 3
}
