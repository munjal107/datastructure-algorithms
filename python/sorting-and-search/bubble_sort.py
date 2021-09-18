def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(n-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    print(arr)



if __name__ == '__main__':
    nums = [90,4,3,7,5,76,43,24,45,10]
    bubble_sort(nums)