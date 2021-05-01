from utils import *

@time_it
def linear_search(numbers, key):
    for i, num in enumerate(numbers):
        if num == key:
            return i
    return -1

@time_it
def binary_search(numbers, key):
    left = 0
    right = len(numbers) - 1

    while left <= right:
        mid = (right + left) //2
        num = numbers[mid]
        if num == key:
            return mid

        if key < num:
            right = mid - 1
        else:
            left = mid + 1
    
    return - 1

#@time_it
def recursive_binary_search(numbers, key, left, right):
    mid = (left + right) // 2
    if right < left:
        return -1
    num = numbers[mid]
    if key == num:
        return mid
    elif key <  num:
        return recursive_binary_search(numbers, key, left, mid-1)
    else:
        return recursive_binary_search(numbers, key, mid+1, right)


if __name__ == '__main__':
    numbers = list(range(10000000))
    key = 9999999
    print(binary_search(numbers, key))
    print(recursive_binary_search(numbers, key, 0, len(numbers)-1))
    print(linear_search(numbers, key))
