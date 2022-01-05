# Time Complexity : O(n)
# Space Complexity : O (1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:

        count = 0
        result = 0
        
        # Iterate through the next element and check if the diff is same.
       
        for i in range(2, len(nums)) :
                if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] :
                    # If yes add into the count and update the result
                    count += 1
                    result += count
                else :
                    # If no, then restart the count
                    count = 0
                
        return result