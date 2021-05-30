import sys

class Arrays:
    # Find the maximum and minimum element in an array
    def min_max_element(self, arr):
        minimum = arr[0]
        maximum = arr[0]

        for num in arr[1:]:
            if num < minimum:
                minimum = num
            elif num > maximum:
                maximum = num
        
        print("Min:", minimum, "Max:", maximum)
    
    # Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
    def sort_without_algo(self, arr):
        low = 0
        mid = 0
        high = len(arr)-1

        while mid <= high:
            if arr[mid] == 0:
                arr[mid], arr[low] = arr[low], arr[mid]
                mid += 1
                low += 1
            elif arr[mid] == 1:
                mid += 1
            else:
                arr[mid], arr[high] = arr[high], arr[mid]
                high -= 1

        print("# Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo")
        print(arr)
    
    # Move all the negative elements to one side of the array 
    def move_negative_elements(self, arr):
        low = 0

        for i in range(len(arr)):
            if arr[i] < 0:
                arr[i], arr[low] = arr[low], arr[i]
                low += 1
        print(arr)
    
    # Find the Union and Intersection of the two sorted arrays.
    def union_intersection(self, arr1, arr2):
        itnersect = []

        for num in arr1:
            if num in arr2:
                itnersect.append(num)
        
        arr1.extend(arr2)
        union = list(set(arr1))
        
        print("union", union)
        print("Intersection", itnersect)

    # Largest Sum Contiguous Subarray
    def largest_cont_sum(self, arr):
        max_ending_here = 0
        max_so_far = -sys.maxsize

        for i in range(len(arr)):
            max_ending_here = max_ending_here + arr[i]
            if max_ending_here < 0:
                max_ending_here = 0
            elif max_so_far < max_ending_here:
                max_so_far = max_ending_here
        
        print(max_so_far)
    
    # Minimum number of jumps to reach end
    # https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
    def min_jumps_to_end_dynamic(self, arr):
        n = len(arr)
        jumps = [0 for i in range(n)]
        
        if n==0 or arr[0]==0:
            return -1
        
        jumps[0] = 0

        for i in range(1,n):
            jumps[i] = sys.maxsize
            for j in range(i):
                if i <= j + arr[j] and jumps[j] != sys.maxsize:
                    jumps[i] = min(jumps[i], jumps[j] + 1)
                    break
        return jumps[n-1]

    

if __name__ == '__main__':
    obj = Arrays()

    arr =  [3,4,53,23,25,23,53,465,86,3,-1,34,56]
    obj.min_max_element(arr)

    arr = [0,1,2,0,0,1,1,2,2,2,1,0,0,2,1]
    obj.sort_without_algo(arr)

    arr = [1,2,-1,-4,5,6,-5,-7,5]
    obj.move_negative_elements(arr)

    arr1 = [1,2,3,4,5]
    arr2 = [3,4,6,7]
    obj.union_intersection(arr1, arr2)

    arr = [-2, -3, 4, -1, -2, 1, 5, -3]
    # arr = [-2, -3, 4, -1, -2, 1, -90, 100] # 100
    obj.largest_cont_sum(arr)

    arr = [1, 3, 6, 3, 2, 3, 6, 8, 9, 5]
    print(obj.min_jumps_to_end_dynamic(arr))