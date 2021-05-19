import time

def get_starttime():
    return time.time()

def get_execution_time(start_time):
    e = time.time()-start_time
    print(e)


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, num in enumerate(nums):
            for j,n in enumerate(nums[i+1:]):
                if num+n == target:
                    return [i, j+i+1]

    def twoSum_v1(self, nums, target):
        d = dict()
        for i,num in enumerate(nums):
            c = target - num
            if c not in d:
                d[num] = i
            else:
                return [d[c], i]
    

    def get_two_nums(self, nums, target):
        d = []
        for i,num in enumerate(nums):
            c = target - num
            if c not in d:
                d.append(num)
            else:
                return c, num
    
    def get_three_nums(self, nums, target):
        d = {}
        for i, num in enumerate(nums):
            d[num] = i

        for i, num in enumerate(nums):
            new_target = target-num
            n1, n2 = self.get_two_nums(nums[i+1:], new_target)
            return [i, d[n1], d[n2]]

    def get_sum_of_three_nums(self, nums, target):
        output = []
        for i, num in enumerate(nums):
            new_target = target-num
            try:
                n1, n2 = self.get_two_nums(nums[i+1:], new_target)
                output.append([num, n1, n2])
            except:
                pass
        return output
    

if __name__ == '__main__':
    nums = [3,2,4]
    nums = [3,3]
    target = 6
    obj1 = Solution()
    
    # st = get_starttime()
    # lst = obj1.twoSum(nums, target)
    # print(lst)
    # get_execution_time(st)

    # st = get_starttime()
    # lst = obj1.twoSum_v1(nums, target)
    # print(lst)
    # get_execution_time(st)

    # nums = [3, 2, 4, 5, 6]
    # target = 11
    # st = get_starttime()
    # lst = obj1.get_three_nums(nums, target)
    # print(lst)

    nums = [-1,0,1,2,-1,-4]
    target = 0
    st = get_starttime()
    lst = obj1.get_sum_of_three_nums(nums, target)
    print(lst)