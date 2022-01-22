# Time: O(n)
# Space: O(1)
class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 3:
            return 0
        #nums.sort()
        ans = 0
        cnt = 1
        prev = nums[1] - nums[0]
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == prev:
                cnt += 1
            else:
                val = cnt + 1
                prev = nums[i] - nums[i-1]
                cnt = 1
                #print(val)
                if val >= 3:
                    val = val - 2
                    ans += ((val*(val+1))/2)
        #print(cnt)
        if cnt >= 2:
            cnt = cnt - 1
            ans += ((cnt*(cnt+1))/2)
        return ans
            
        
        
