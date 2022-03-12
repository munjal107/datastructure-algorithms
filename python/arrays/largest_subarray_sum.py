# https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#


class Solution:
    def lenOfLongSubarr (self, A, N, K) : 
        #Complete the function
        max_len = 0
        total=0
        d = {}
        
        for i,num in enumerate(A):
            total+=num
            if total==K:
                max_len = i+1
            elif d.get(total-K)!=None:
                max_len = max(max_len, i-d.get(total-K))
            elif d.get(K-total)!=None:
                max_len = max(max_len, i-d.get(K-total))
            else:
                d[total]=i
        return max_len
    

