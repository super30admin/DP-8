# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No

#Approach and intuition:

# Brute Force: In O(n^2) explore all slices with length 3 or more for each element and then in O(n) compare if the slice is valid hence O(n^3). To reduce this, we can store the difference and reduce the TC to O(n^2).
# Optimal: Eg. 1,3,5,7,9. Start from the back side(5,7,9), and just keep checking if the difference(2) at 5 is same or not moving forward (5-3 = 2). If this is valid, we add this to our count of o/p. Now, we check for (3,5,7), hence we add 2 to our o/p count as 3,5,7 is valid and 3,5,7,9 is also valid as the prev answer told us that 5,7,9 was valid. Now, for next 3 elements 1,3,5 we add 3 to count after comparing the difference is valid: as 1,3,5 and 1,3,5,7 and 1,3,5,7,9 are valid: basically all slices including that element should be valid. 
# For the eg. 1,14,15,16,11,12,13: at 11, we add 1 to count but at 16 we'll add 0 as 16,11,12 isn't valid and anything including 16 won't be valid as well. 

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if A == None or len(A)==0:
            return 0
        
        prev, sumT = 0,0
        
        for x in range(len(A)-3, -1, -1):
            if A[x]-A[x+1] == A[x+1] - A[x+2]:
                prev += 1
                sumT += prev
            else:
                prev = 0
        
        return sumT
            