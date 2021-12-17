class Solution:
    def findPeakElement(self, nums):
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            if nums[0]<nums[1]:
                return 1
            else:
                return 0
        l,r = 0, len(nums)-1
        while(l<=r):
            m = (l+r) // 2
            
            if (m-1<0 or nums[m-1] < nums[m]) and (m+1 >= len(nums) or nums[m] > nums[m+1]):
                return m
            elif nums[m-1] > nums[m]:
                r = m-1
            else:
                l = m + 1
                        

if __name__ == '__main__':
    nums = [1,2,1,3,5,6,7]
    obj = Solution()
    print(obj.findPeakElement(nums))

