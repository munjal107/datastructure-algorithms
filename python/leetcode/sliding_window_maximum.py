# https://leetcode.com/problems/sliding-window-maximum/
# 239

from collections import deque

class Solution:
    def maxSlidingWindow(self, nums, k):
        q = deque()
        
        for i in range(k):
            while q and nums[q[-1]] <= nums[i]:
                q.pop()
            q.append(i)
        
        out = []
        for i in range(k, len(nums)):
            out.append(nums[q[0]])
            while q and q[0] <= i-k:
                q.popleft()
            while q and nums[q[-1]] <= nums[i]:
                q.pop()    
            q.append(i)
        out.append(nums[q[0]])
        print(out)



if __name__ == '__main__':
    obj = Solution()
    nums = [1,3,-1,-3,5,3,6,7]
    k = 3
    nums = [1,3,1,2,0,5]
    k = 3
    obj.maxSlidingWindow(nums, k)
