'''
Time Complexity: 0(n)
Space Complexity: 0(n)
Run on LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        # initialize memory1D
        self.__memory1D = None
    
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        # initialize __memory1D
        self.__memory1D = [0]*len(nums)
        
        # initialize count
        sliceCount = 0
        
        # fill up the memory1D from behind
        start = (len(nums)-1)-2 # will be at 10th index
        
        for i in range(start,-1,-1):
            if (nums[i]-nums[i+1]) == (nums[i+1]-nums[i+2]):
                '''
                if its the arithmetic slice, fill-up the memory1D current index, 
                by add 1 to the previous value
                '''
                self.__memory1D[i] = 1+self.__memory1D[i+1]
                sliceCount += self.__memory1D[i]
        '''end of iteration'''
        
        # print("Memory1D is:\t",self.__memory1D)
        
        return sliceCount
        
        