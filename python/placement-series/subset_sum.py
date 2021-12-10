# https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rQ6cnlaHRMuOp4H_D-7hwP&index=4


# User function Template for python3
class Solution:
    def get_subset_sum(self, arr, index, n, total, ans):
        if(index == n):
            ans.append(total)
            return
        # print(sum)
        # select the element
        # total += arr[index]
        self.get_subset_sum(arr, index+1, n, total+arr[index], ans)
        # self.get_subset_sum(arr, index+1, n, total, ans)

        # not select
        self.get_subset_sum(arr, index+1, n, total, ans)

    def subsetSums(self, arr, N):
            # code here
        ans = []
        self.get_subset_sum(arr, 0, len(arr), 0, ans)
        ans.sort()
        return ans

# {
#  Driver Code Starts
# Initial Template for Python 3


if __name__ == '__main__':
 
    arr = [3, 1, 4]
    N = len(arr)
    ob = Solution()
    print(arr, N)
    ans = ob.subsetSums(arr, N)
    ans.sort()
    for x in ans:
        print(x, end=" ")
    print("")

# } Driver Code Ends
