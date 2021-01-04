# Time:- O(n)
# Space:- O(1)
# Approach:- A slice consists of 3 numbers atleast and the difference of the first 2 numbers must equal the difference of the second 2 numbers, if it is so the number of slices increases. If there are more than one such consecutive slices the total number of slices increases by previous_slices+1. 
class Solution:
    def numberOfArithmeticSlices(self, a: List[int]) -> int:
        # if there are less than 3 numbers slices are not possible
        if len(a)<3:
            return 0
        d=a[1]-a[0]
        count=0
        maxcount=0
        for i in range(2,len(a)):
            if a[i]-a[i-1]==d:
                # for consecutive slice count
                count+=1
                # for global slice count
                maxcount+=count
            else:
                count=0
                d=a[i]-a[i-1]
        return maxcount