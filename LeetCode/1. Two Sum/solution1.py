# O(n), multiple passes

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache = {}
        for i, num in enumerate(nums):
            cache[num] = i
        for i, num in enumerate(nums):
            if (target - num) in cache and cache[target-num] != i:
                return [cache[target-num], i]
        return []
