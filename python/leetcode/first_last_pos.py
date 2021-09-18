# Prob-34
# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)
        while low<=high:
            mid = (low+high) // 2
            num = nums[mid]
            if num == target:
                print(target)
            elif num < target:
                low = mid + 1
            else:
                high = mid - 1

