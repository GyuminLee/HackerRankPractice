class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        results = []
        self.dfs(results, [], nums, 0)
        return results
    
    def dfs(self, results, curr, nums, start):
        results.append(curr[:])
        for i in range(start, len(nums)):
            curr.append(nums[i])
            self.dfs(results, curr, nums, i+1)
            curr.pop()
