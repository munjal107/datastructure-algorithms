

def binary_search(arr, l , h, key):
    while l<=h:
        m = (l+h)//2
        if arr[m] == key:
            return m
        else:
            if key > arr[m]:
                l = m + 1
            else:
                r = m - 1


def search_in_array(arr, key):
    l = 0
    h = 1
    temp = arr[0]

    while temp < key:
        l = h
        h = 2*h
        temp = arr[h]

    return binary_search(arr, l , h, key)



if __name__ == "__main__":
    print("hello")
    arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170]
    ans = search_in_array(arr,10)
    if ans == -1:
        print ("Element not found")
    else:
        print("Element found at index",ans)