# Time - O(N)
# Space - O(N)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if not nums or len(nums) < 3 == 0:
            return 0
        
        
        count = 0
        dp = [0] * len(nums)
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1] + 1
                count += dp[i] # calc running sum and return at end or skip and return sum(dp)

            # we can skip else as we default the arr to 0 if no such slice is found
                
                
        return count


# Instead of storing a dp array, we can use a single variable since we use that to calc slices

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if not nums or len(nums) < 3 == 0:
            return 0
        
        prev = 0
        count = 0
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                prev = prev + 1
                count += prev # calc running sum and return at end or skip and return sum(dp)
                
            else:
                prev = 0
                
        return count
                