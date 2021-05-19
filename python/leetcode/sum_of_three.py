# https://leetcode.com/problems/3sum/
class Solution(object):
    def get_two_nums(self, nums, target):
        d = []
        temp = []
        for i,num in enumerate(nums):
            c = target - num
            if c not in d:
                d.append(num)
            else:
                temp.append([c, num])
        return temp

    def twoSum_v1(self, nums, target):
        d = dict()
        temp = []
        for i,num in enumerate(nums):
            c = target - num
            if c not in d:
                d[num] = i
            else:
                temp.append([c, num])
        return temp
    
    def twoSum_v2(self, nums, target):
        d = []
        for i,num in enumerate(nums):
            c = target - num
            if c not in d:
                d.append(num)
            else:
                return [c, num]

    def threeSum(self, nums):
        output = []
        for i, num in enumerate(nums):
            target = -num
            # temp = nums.copy()
            # temp.pop(i)
            temp = nums[i+1:]
            try:
                temp = self.get_two_nums(temp, target)
                for t in temp:
                    output.append(sorted([num, *t]))
            except:
                pass
        output = sorted(list(map(list, set(tuple(i) for i in output))))
        return output


    def threeSum_v1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        output = []
        for i, num in enumerate(nums):
            target = -num
            try:
                temp = self.twoSum_v1(nums[i+1:], target)
                if len(temp)>0:
                    for t in temp:
                        if len(t)>0:
                            output.append([num, *t])
            except:
                pass
        t = []
        for k in output:
            t.append(sorted(k))
        output = list(map(list, set(tuple(i) for i in t)))
        return output
    
    def threeSum_v2(self, nums):
        output = []
        for i, num in enumerate(nums):
            for j, n1 in enumerate(nums[i+1:]):
                for k, n2 in enumerate(nums[i+2:]):
                    if num+n1+n2==0:
                        output.append(sorted([num,n1,n2]))
        output = list(map(list, set(tuple(i) for i in output)))
        return output


if __name__ == '__main__':
    nums = [-1,0,1,2,-1,-4]
    # nums = [-1,0,1,2,-1,-4,-2,-3,3,0,4]
    obj1 = Solution()
    lst = obj1.threeSum_v2(nums)
    print(lst)