def insertion_sort(numbers):
    n = len(numbers)
 
    for i in range(1,n):
        k = numbers[i]
        j = i-1
        while j>=0 and k < numbers[j]:
            numbers[j+1] = numbers[j]
            j-=1
        numbers[j+1] = k
        
    print(numbers)

if __name__ == '__main__':
    nums = [90,4,3,7,5,76,43,24,45,10]

    insertion_sort(nums)