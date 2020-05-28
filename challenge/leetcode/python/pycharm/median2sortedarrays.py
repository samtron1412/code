import bisect
from typing import List


class Solution:
    def kSmallest(self, arr1, arr2, k):
        if (k//2 == 0):
            if arr1[0] < arr2[0]:
                return arr1[0]
            else:
                return arr2[0]
        a1 = arr1[k//2]
        if k//2 >= len(arr2):
            a2 = arr2[len(arr2)-1]
        else:
            a2 = arr2[k//2]
        if a1 <= a2:
            if k//2 >= len(arr1):
                self.kSmallest(arr1, arr2, k)
            else:
                self.kSmallest(arr1[k//2:], arr2, k-k//2)
        else:
            if k//2 >= len(arr2):
                self.kSmallest(arr1, arr2, k)
            else:
                self.kSmallest(arr1, arr2[k//2:], k-k//2)

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        return self.kSmallest(nums1, nums2, (len(nums1)+len(nums2))//2+1)

    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        l = []
        for i in range(n):
            l.append(0)
        max1 = 0
        for i in range(n):
            max2 = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    if l[j] + 1 > max2:
                        max2 = l[j] + 1
            l[i] = max2
            if max2 > max1:
                max1 = max2
        return max1 + 1

    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums: return 0
        highest = max(nums)
        memo = [highest + 1 ] * len(nums)

        for num in nums:
            pos = bisect.bisect_left(memo, num)
            memo[pos] = num

        return bisect.bisect_left(memo, highest+1)

    def lengthOfLIS(self, nums: List[int]) -> int:
        arr = []
        for num in nums:
            i = bisect.bisect_left(arr, num)
            if i < len(arr):
                arr[i] = num
            else:
                arr.append(num)
        return len(arr)

    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [-float("inf")]

        for i, num in enumerate(nums):
            if dp[-1] < num:
                dp.append(num)
            else:
                i = bisect.bisect_left(dp, num)
                if num < dp[i]:
                    dp[i] = num

        return len(dp) - 1

    def missing(self, A, k):
        numMisses = A[-1] - A[0] + 1 - len(A)
        if k > (numMisses):
            return A[-1] + k - numMisses
        return self.missing(A[:(len(A)+1)//2], k)



def main():
    sol = Solution()
    nums1 = [1, 3, 4, 5]
    nums2 = [2]
    nums3 = [10,9,2,5,3,7,101,18]
    nums4 = [4, 7, 9, 10]
    # print(sol.findMedianSortedArrays(nums1, nums2))
    print(sol.missing(nums4, 1))
    print(sol.missing(nums4, 2))
    print(sol.missing(nums4, 3))
    print(sol.missing(nums4, 4))

if __name__ == '__main__':
    main()
