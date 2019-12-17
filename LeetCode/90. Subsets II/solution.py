class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        self.dfs(res, [], nums, 0)
        return res
    
    def dfs(self, res, curr, nums, start):
        res.append(curr[:])
        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i-1]:
                continue
            curr.append(nums[i])
            self.dfs(res, curr, nums, i+1)
            curr.pop()
