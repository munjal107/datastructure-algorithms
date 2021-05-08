def bubble_sort(numbers):
    n = len(numbers)
    for i in range(n):
        for i in range(1,n):
            if numbers[i-1] > numbers[i]:
                numbers[i-1], numbers[i] =  numbers[i], numbers[i-1]
    print(numbers)


if __name__ == '__main__':
    nums = [90,4,3,7,5,76,43,24,45,10]

    bubble_sort(nums)