def swap(a, b, arr):
    arr[a], arr[b] = arr[b], arr[a]

def partition(arr,  start, end):
    pivot_index = start
    pivot = arr[pivot_index]

    while start < end:
        while start < len(arr) and arr[start] <= pivot:
            start+=1
        
        while arr[end] > pivot:
            end-=1
        
        if start < end:
            swap(start, end, arr)

        swap(end, pivot_index, arr)
    
    return end



def quick_sort(arr, start, end):
    if start < end:
        p = partition(arr, start, end)
        
        quick_sort(arr, start, p-1)
        quick_sort(arr, p+1, end)



if __name__ == '__main__':
    nums = [90,4,3,7,5,76,43,24,45,10]

    quick_sort(nums, 0, len(nums)-1)
    print(nums)