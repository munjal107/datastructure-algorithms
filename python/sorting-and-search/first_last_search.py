# 34. Find First and Last Position of Element in Sorted Array


def findFirst(nums, target, l, h):
    first = -1
    while l<=h:
        m = (l+h) // 2
        if nums[m] >= target:
            h = m - 1
        else:
            l = m + 1
        if nums[m]==target:
            first = m
    return first


def findLast(nums, target, l, h):
    last = -1
    while l<=h:
        m = (l+h) // 2
        if nums[m] == target:
            last = m
        if nums[m] <= target:
            l = m + 1
        else:
            h = m - 1
    return last


class Solution:
    def searchRange(self, nums, target: int):
        n = len(nums)
        first = findFirst(nums, target, 0, n-1)
        # print("find last")
        last = findLast(nums, target, 0, n-1)
        
        return [first, last]
        

if __name__ == "__main__":
    arr = [5,7,7,8,8,10]
    s = Solution()
    o = s.searchRange(arr, 8)
    print(o)