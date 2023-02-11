"""Quick sort
>>> quicksort([9,8,7,6,5,4,3,2,1])
[1, 2, 3, 4, 5, 6, 7, 8, 9]
>>> quicksort([4,-2,0,1,-1,0])
[-2, -1, 0, 0, 1, 4]
"""

import random

def quicksort(lst):
    def partition(lst, low, high):
        pivot = lst[random.randint(low, high)]
        while True:
            while lst[low] < pivot:
                low += 1
            while lst[high] > pivot:
                high -= 1
            if low >= high: return high
            lst[low], lst[high] = lst[high], lst[low]
            low += 1
            high -= 1

    def recur_qs(lst, low, high):
        if low < high:
            pos = partition(lst, low, high)
            recur_qs(lst, low, pos)
            recur_qs(lst, pos + 1, high)

    recur_qs(lst, 0, len(lst)-1)
    print(lst)

if __name__ == "__main__":
    import doctest
    doctest.testmod()
