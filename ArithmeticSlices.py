class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        '''
        T = O(N)
        S = O(1)
        '''
        if not nums or len(nums) <3 :return 0 
        count = 0 
        n = len(nums)
        prev = 0 
        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                prev = prev + 1 
                count = count + prev 
            else:
                prev = 0
        return count
        
    def subOptimalnumberOfArithmeticSlices(self, nums: List[int]) -> int:
        '''
        Bottom up approach 
        T = O(N)
        S = O(N)
        '''
        if not nums or len(nums) <3 :return 0 
        count = 0 
        n = len(nums)
        dp = [0]*n
        for i in range(n-3, -1, -1):
            if nums[i+1] - nums[i] == nums[i+2] - nums[i+1]:
                dp[i] = dp[i+1] + 1
                count = count + dp[i]
        return count
    
    def BruteForcenumberOfArithmeticSlices(self, nums: List[int]) -> int:
        '''
        T = O(N^2)
        S = O(1)
        '''
        if not nums or len(nums) <3 :return 0 
        count = 0 
        for i in range(len(nums)-2 ):
            diff = nums[i+1] - nums[i]
            for j in range(i+2, len(nums)  ):
                if nums[j] - nums[j-1] == diff :
                    count += 1 
                else:
                    break 
        return count 
    
    
