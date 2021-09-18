
# reference
# https://www.geeksforgeeks.org/find-k-closest-elements-given-value/

class KNearnestNeighbor:
    # Function to find the cross over point
    # (the point before which elements are
    # smaller than or equal to x and after
    # which greater than x)urs:
    def find_crossover(self, arr, low, high, n):

        if arr[high] <= n:
            return high
        
        if arr[low] > n:
            return low
        
        mid = (low + high) // 2
        if arr[mid] <= n and arr[mid+1] > n:
            return mid
        
        if arr[mid] < n:
            return self.find_crossover(arr, mid + 1, high, n)
        else:
            return self.find_crossover(arr, low, mid - 1, n)

    def sorted_array(self, arr, n, k):
        len_arr = len(arr)
        out = []
        
        # Find the crossover point
        l = self.find_crossover(arr, 0, len_arr-1, n)
        # Right index to search
        r = l + 1
        count = 0

        # print(arr[l])
        # If x is present in arr[], then reduce
        # left index. Assumption: all elements
        # in arr[] are distinct
        if arr[l]==n:
            l-=1
        
        while l>=0 and r < len_arr and count < k:
            if n-arr[l] < arr[r]-n:
                out.append(arr[l])
                l-=1
            else:
                out.append(arr[r])
                r+=1
            count+=1
        
        while count < k and l >= 0:
            out.append(arr[l])
            l-=1
            count+=1
        
        while count < k and r < len_arr:
            out.append(arr[r])
            r+=1
            count+=1

        print(out)

    def findClosestElements(self, arr, k, x):
        left = 0
        right = len(arr) - k
        
        while left < right:
            mid = left + (right - left)//2
			
            if x <= arr[mid]:
                right = mid
            elif x >= arr[mid + k]:
                left = mid + 1
            elif x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left : left + k]

    def unsorted_array(self, arr, n, k):
        pass


if __name__ == '__main__':
    arr =[12, 16, 22, 30, 35, 39, 42,
              45, 48, 50, 53, 55, 56]
                 
    x = 35
    k = 4

    obj = KNearnestNeighbor()
    # obj.sorted_array(arr, x, k)
    print(obj.findClosestElements(arr, k , x))