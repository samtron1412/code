"""Giving an array of digits that represents an integer
Adding one to that number

>>> add_one([9])
[1, 0]
>>> add_one([1])
[2]
>>> add_one([1, 2])
[1, 3]
>>> add_one([9, 9])
[1, 0, 0]
>>> add_one_recur([9])
[1, 0]
>>> add_one_recur([1])
[2]
>>> add_one_recur([1, 2])
[1, 3]
>>> add_one_recur([9, 9])
[1, 0, 0]
"""
def add_one(lst):
    carry = 1
    for i in range(len(lst) - 1, -1, -1):
        total = lst[i] + carry
        carry = total // 10
        lst[i] = total % 10
    if carry != 0:
        lst[:0] = [carry]
    return lst

def add_one_recur(lst):
    if len(lst) == 1:
        total = lst[0] + 1
        if total > 9:
            return [total // 10, total % 10]
        else:
            return [total]
    rest = add_one_recur(lst[1:])
    if len(rest) == len(lst) - 1:
        return lst[:1] + rest
    else:
        return add_one_recur(lst[:1]) + rest[1:]

