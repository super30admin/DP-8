-------------------------Update Board------------------------------------------
# Time Complexity : O(N) as N is the length of array
# Space Complexity : O(1)  No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will iterate through array and check if the difference between the previous two elements and current element and previous element os 
# same or not. If it is same we will add 1 to the prev count, else make the prev count to 0. And add the prev to the total sum.
# Return the total sum at the end to get total number of arithmetic numbers.


class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if not A or len(A)<3:
            return 0
        
        s = 0
        prev = 0
        for i in range(2,len(A)):
            if A[i] -A[i-1] == A[i-1] -A[i-2]:
                prev +=1
                s += prev
            else:
                prev = 0
        return s