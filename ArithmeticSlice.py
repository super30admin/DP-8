#TC: O(n^2)
#SC: O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        result=0
        for i in range(0, len(nums)-1):
            diff=nums[i+1]-nums[i]
            for j in range(i+1, len(nums)-1):
                if nums[j+1]-nums[j]==diff:
                    result+=1
                else:
                    break

        return result


#TC: O(n)
#SC: O(n)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        result=0
        dp=[0]*len(nums)
        for i in range (2,len(nums)):
            if nums[i-1]-nums[i-2] == nums[i]-nums[i-1]:
                dp[i]=dp[i-1]+1
                result=result+dp[i]
        
        return result
        
#TC: O(n)
#SC: O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        result=0
        prev=0
        for i in range (2,len(nums)):
            if nums[i-1]-nums[i-2] == nums[i]-nums[i-1]:
                current=prev+1
                result=result+current
                prev=current
            else:
                prev=0
        
        return result