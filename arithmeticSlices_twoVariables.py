'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on LeetCode: Yes
'''
class Solution:
    
    '''
    Just maintain previous and current values
    '''
    
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        previous = 0
        current = 0
        
        # initialize count
        sliceCount = 0
        
        start = (len(nums)-1)-2 # will be at 10th index
        
        for i in range(start,-1,-1):
            if (nums[i]-nums[i+1]) == (nums[i+1]-nums[i+2]):
                current = 1 + previous
                sliceCount += current
            else:
                current = 0
            previous = current
        '''end of iteration'''
        
        # print("Memory1D is:\t",self.__memory1D)
        
        return sliceCount
        
        
        
        