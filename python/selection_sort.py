def selection_sort(numbers):
    n = len(numbers)

    for i in range(n):
        idx = i
        for j in range(i+1, n):
            if numbers[idx] > numbers[j]:
                idx = j
        if idx != i:
            numbers[idx], numbers[i] = numbers[i] , numbers[idx]

    print(numbers)

if __name__ == '__main__':
    nums = [90,4,3,7,5,76,43,24,45,10]
    selection_sort(nums)