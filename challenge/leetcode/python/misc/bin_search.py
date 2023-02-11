"""This is a quick implementation for binary search
>>> bin_search([i for i in range(1000)], 3)
3
"""

def bin_search(lst, k):
    """
    >>> bin_search([2*i for i in range(1000)], 6)
    3
    """
    low, high = 0, len(lst) - 1
    while low < high:
        mid = (low + high) // 2
        if lst[mid] > k: high = mid
        elif lst[mid] < k: low = mid
        else: return mid  # key found
    return -1  # key not found

if __name__ == "__main__":
    import doctest
    doctest.testmod()
