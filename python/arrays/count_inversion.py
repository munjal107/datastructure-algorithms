class Solution:
    #User function Template for python3
    
    # arr[]: Input Array
    # N : Size of the Array arr[]
    #Function to count inversions in the array.
    def merge(self, left, right, arr):
        n = len(left)
        m = len(right)
        
        i=j=k=0
        inv_count = 0
        while i<n and j<m:
            if left[i]<=right[j]:
                arr[k]=left[i]
                i+=1
            else:
                arr[k]=right[j]
                j+=1
                inv_count += (n-i)
            k+=1
            
        while i<n:
            arr[k]=left[i]
            i+=1
            k+=1
        while j<m:
            arr[k]=right[j]
            j+=1
            k+=1
        return inv_count
    
    def merge_sort(self, arr):
        inv_count = 0
        if len(arr) > 1:
            mid = len(arr)//2
            
            left = arr[:mid]
            right = arr[mid:]
            inv_count += self.merge_sort(left)
            inv_count += self.merge_sort(right)
            
            inv_count += self.merge(left, right, arr)
    
            
        return inv_count
        

    
    def inversionCount(self, arr, n):
        # Your Code Here
        inv_count = self.merge_sort(arr)
        # print(arr)
        return inv_count

#{ 
#  Driver Code Starts
#Initial Template for Python 3

# import atexit
# import io
# import sys

# _INPUT_LINES = sys.stdin.read().splitlines()
# input = iter(_INPUT_LINES).__next__
# _OUTPUT_BUFFER = io.StringIO()
# sys.stdout = _OUTPUT_BUFFER

# @atexit.register

# def write():
#     sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__=='__main__':
    arr = [2, 4, 1, 3, 5]  # Output: 3
    n=len(arr)
    obj = Solution()
    print(obj.inversionCount(arr,n))
# } Driver Code Ends