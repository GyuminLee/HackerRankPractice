# O(n), one pass

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache = {}
        for i, num in enumerate(nums):
            tmp = target - num
            if tmp in cache:
                return [cache[tmp], i]
            else:
                cache[num] = i
        return []
