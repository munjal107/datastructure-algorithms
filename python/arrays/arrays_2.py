class Solution:
    # Reverse the array
    def reverse_array(self, arr):
        print("reverse -> ", arr[::-1])
        # print("reverse -> ", arr)
        # iterative way
        start = 0
        end = len(arr)-1
        while start<end:
            arr[start], arr[end] = arr[end], arr[start]
            start += 1
            end -= 1
        
        print(arr)

        # recursive way
        def recursive_reverse(arr, s, e):
            if s > e:
                return
            arr[s], arr[e] = arr[e], arr[s]
            recursive_reverse(arr, s+1, e-1)
        
        print("before arr-",arr)
        recursive_reverse(arr,0, len(arr)-1)
        print("after arr-",arr)


        # return arr[::-1]

    # Find the maximum and minimum element in an array
    def min_max_element(self, arr):

        print("arr->",arr)
        # iterative search
        if arr[0] >= arr[1]:
            min_ele = arr[1]
            max_ele = arr[0]
        else:
            min_ele = arr[0]
            max_ele = arr[1]
        
        for i in range(2, len(arr)):
            if arr[i] > max_ele:
                max_ele = arr[i]
            elif arr[i] < min_ele:
                min_ele = arr[i]
        
        print("Min-max element ->", min_ele, max_ele)

        # recursive divide and conquer
        def get_min_max(arr, s, e):
            """
                return min, max element
            """
            if s==e:
                return arr[s], arr[e]
            
            elif s+1 == e:
                if arr[s] > arr[e]:
                    return arr[e], arr[s]
                return arr[s], arr[e]
            else:
                mid = int((s+e)/2)
                amn, amx = get_min_max(arr, s, mid)
                bmn, bmx = get_min_max(arr, mid+1, e)
                return min(amn, bmn), max(amx, bmx)

        arr = [1000, 11, 445, 1, 330, 3000]
        mn, mx = get_min_max(arr, 0, len(arr)-1)

        print("recursice min-max -> ", mn, mx) 


        # with min comparisions
        n = len(arr)
        if n%2==0:
            mn = min(arr[0], arr[1])
            mx = max(arr[0], arr[1])
            i=2
        else:
            mn, mx = arr[0]
            i = 1

        for j in range(i, n-1, 2):
            if arr[j] > arr[j+1]:
                if arr[j] > mx:
                    mx = arr[j]
                if arr[j+1] < mn:
                    mn = arr[j+1]
            else:
                if arr[j+1] > mx:
                    mx = arr[j+1]
                if arr[j] < mn:
                    mn = arr[j]

        print("min comparison ->", mn, mx)

    # find kth largest ele 
    # quick select algo
    def kth_largest_element(self, arr, k):
        n = len(arr)

        def partition(arr, l, r):
            pivot = arr[r]
            low = l
            while l<r:
                if arr[l] < pivot: #arr[r]:
                    arr[l], arr[low] = arr[low], arr[l]
                    low += 1
                l+=1
            arr[low], arr[r] = arr[r], arr[low]
            return low

        # this find k smallest element
        def quickselect(arr, k):
            pos = partition(arr, 0, len(arr)-1)
            if k > pos+1:
                return quickselect(arr[pos+1:], k-pos-1)
            elif k < pos+1:
                return quickselect(arr[:pos], k)
            else:
                return arr[pos]
        # convert the kth largest to smallest
        kth_ele = quickselect(arr, len(arr)+1-k)
        print("kth ele->", kth_ele)
    
    def sort_array_012(self, arr):
        low = mid = 0
        high = len(arr) - 1
        while mid<=high:
            if arr[mid]==1:
                mid+=1
            elif arr[mid]==0:
                arr[mid], arr[low] = arr[low], arr[mid]
                mid+=1
                low+=1
            else:
                arr[mid], arr[high] = arr[high], arr[mid]
                high-=1
        
        print(arr)

    def shift_all_negatives(self, arr):
        j = 0
        n = len(arr)
        for i in range(n):
            if arr[i] < 0:
                arr[i], arr[j] = arr[j], arr[i]
                j+=1
        print(arr)

        # two pointer approach
        arr = [-12, 11, -13, -5, 6, -7, 5, -3, -6]
        print("original arr ->", arr)
        left = 0
        right = n-1
        while left<right:
            if arr[left]<0 and arr[right]<0:
                left += 1
            elif arr[left]>0 and arr[right]<0:
                arr[left], arr[right] = arr[right], arr[left]
            elif arr[left]>0 and arr[right]>0:
                right-=1
            else:
                left+=1
                right-=1
        print(arr)


    def union_and_intersection(self, nums1, nums2):
        # union 
        # list(set(nums1) || set(nums2))
        # intersection
        # list(set(nums1) & set(nums2))

        # intersection
        # To find set in O(m+n) time and O(m) space m=len(nums1)
        d = {}
        for num in nums1:
            d[num] = True
        
        res = []
        for num in nums2:
            if d.get(num):
                res.append(num)
                d[num]=False

        # union after sorting
        # O(mlog(m)+nlog(n))
        nums1.sort()
        nums2.sort()
        l = 0
        r = 0
        m = len(nums1)
        n = len(nums2)
        res = []
        print(nums1, nums2)
        while l<m and r<n:
            if nums1[l] > nums2[r]:
                r+=1
            elif nums1[l] < nums2[r]:
                l+=1
            else:
                res.append(nums1[l])
                l+=1
                r+=1
        
        print("res->",res)



if __name__ == "__main__":
    obj = Solution()

    # reverse array
    arr = [2,3,4,5,6,7]
    # obj.reverse_array(arr)
    # print(obj.reverse_array(arr))

    # Find the maximum and minimum element in an array
    arr = [2, 2, 4, 3, 6, 4, 9, 1, 10, 2, 100, -4, 6]
    # obj.min_max_element(arr)

    # Find the "Kth" max and min element of an array
    # find kth largest ele 
    nums = [3,2,3,1,2,4,5,5,6]
    k = 4
    nums, k = [3,2,3,1,2,4,5,5,6], 4 # ans=4
    # obj.kth_largest_element(nums, k)

    # Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
    nums = [2,0,2,1,1,0]
    nums = [2,0,2,0,1,0]
    # obj.sort_array_012(nums)

    # Move all the negative elements to one side of the array 
    arr = [-12, 11, -13, -5, 6, -7, 5, -3, -6]
    # obj.shift_all_negatives(arr)

    # Find the Union and Intersection of the two  arrays.
    nums1 = [4,9,5]
    nums2 = [9,4,9,8,4]
    obj.union_and_intersection(nums1, nums2)

