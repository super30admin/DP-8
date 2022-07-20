#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        dp=[0]*len(nums)
        count=0
        for i in range(len(nums)-3,-1,-1):
            if nums[i+1]-nums[i]==nums[i+2]-nums[i+1]:
                dp[i]=dp[i+1]+1
                count+=dp[i]
        return count
    
#Time complexity: O(n)
#Space complexity: O(1)    
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        prev=0
        count=0
        for i in range(len(nums)-3,-1,-1):
            if nums[i+1]-nums[i]==nums[i+2]-nums[i+1]:
                prev=prev+1
                count+=prev
            else:
                prev=0
        return count
        
        