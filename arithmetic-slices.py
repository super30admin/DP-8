def numberOfArithmeticSlices(self, nums: List[int]) -> int:
    # tc O(n), sc O(1).
    if len(nums) < 3:
        return 0
    prev_diff = nums[1] - nums[0]
    left = 0
    arithmenticsubarrays_count = 0

    for right in range(2, len(nums)):
        curr_diff = nums[right] - nums[right-1]
        if curr_diff != prev_diff:
            left = right - 1
            prev_diff = curr_diff
            continue

        arithmenticsubarrays_count += right-left+1-2

    return arithmenticsubarrays_count