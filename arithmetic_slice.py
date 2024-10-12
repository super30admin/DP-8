

# Time complexity - O(n)
# Space complexity - O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        cur  = 0
        for i in range(2,n):
            if nums[i-2] - nums[i-1] == nums[i-1] - nums[i]:
                cur += 1
                result += cur
            else: 
                cur = 0
        return result





# Time complexity - O(n)
# Space complexity - O(1)
# class Solution:
#     def numberOfArithmeticSlices(self, nums: List[int]) -> int:
#         n = len(nums)
#         result = 0
#         cur  = 0
#         for i in range(n-3,-1,-1):
#             if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
#                 cur += 1
#                 result += cur
#             else: 
#                 cur = 0
#         return result
            



# Time complexity - O(n)
# Space complexity - O(n)
# class Solution:
#     def numberOfArithmeticSlices(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [0] * n
#         result = 0
#         for i in range(n-3,-1,-1):
#             if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
#                 dp[i] = dp[i+1] + 1
#                 result += dp[i]
#         return result



# Time complexity - O(n^2)
# Space complexity - O(n)
# class Solution:
    # def numberOfArithmeticSlices(self, nums: List[int]) -> int:
    #     n = len(nums)
    #     diff = 0
    #     result = 0
    #     for i in range(n-2):
    #         diff = nums[i+1] - nums[i]
    #         for j in range(i+1,n-1):
    #             if nums[j+1] - nums[j] != diff:break
    #             result+=1
    #     return result

