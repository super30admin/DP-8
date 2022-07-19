'''
Time Complexity: 0(n*n)
Space Complexity: 0(1)
Run on LeetCode: Yes
'''
class Solution:
    
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        sliceCount = 0
        
        # brute force approach
        for i in range(0,len(nums)-2):
            commonDiff = nums[i+1]-nums[i]
            
            for j in range(i+2,len(nums)):
                if nums[j] - nums[j-1] == commonDiff:
                    sliceCount += 1
                else:
                    break
            '''end of inner for loop'''
            
        '''end of outer for loop'''
        
        # print(sliceCount)
        return sliceCount