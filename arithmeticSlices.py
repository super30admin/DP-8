#Time: O(N)
#Space: O(1)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3: 
            return 0
        
        def calc_num(L): 
            return ((L - 3) * L + 2) // 2
        
        i = count = 0 
        j = i + 1
        while i <= len(nums) - 3 and j < len(nums) - 1: 
            if nums[i] - nums[i+1] == nums[j] - nums[j+1]:
                j +=1 
            
            else: # nums[i:j+1] contains valid sequences
                count += calc_num(j+1 - i)
                i = j
                j = i + 1
         
		# handle out of bounds case
        count += calc_num(j+1 - i)
        return count