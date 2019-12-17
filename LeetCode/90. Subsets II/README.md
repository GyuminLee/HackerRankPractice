>[Click here to check](https://leetcode.com/problems/subsets-ii/)

Solution:  
this is an advanced version of [78. Subsets](https://leetcode.com/problems/subsets/). The only difference is we need to remove duplicates. e.g. we want all non-duplicated subsets of [1,2,2]. Then [1,2] and [1,2] are duplicated as we have two number 2.

Compared with the previous code, we only add two lines of code shown as below:
```python
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        self.dfs(res, [], nums, 0)
        return res
    
    def dfs(self, res, curr, nums, start):
        res.append(curr[:])
        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i-1]:  # new line 1
                continue                            # new line 2
            curr.append(nums[i])
            self.dfs(res, curr, nums, i+1)
            curr.pop()
```
However, this is not so easy to understand. The `i > start` not only guarantees that index `i-1` is valid, but also it guarantees that `nums[i]` and `nums[i-1]` are at the same level of the traversing tree. To understand this, let's explain it in details. In the beginning of the loop, `i` is initialized with the value of `start`, as the loop goes, `i` is increasing. However, the value of `i` is always located between `start` and `len(nums)`. Each for-loop represents a series of operations that happens on one level: we include value `nums[i]` and run the recursive function to find all possible subsets with `nums[i]`, and then we remove it to find all possible subsets without the value of `nums[i]`. It all happens in the same level.

![Visualization of the backtracking process of all subsets (contain duplicates) of [1,2,2]](huisu.jpg)
> Visualization of the backtracking process of all subsets (contain duplicates) of `[1,2,2]`

As we can clearly see in the above illustration, the duplicated `[1,2]` comes from the same level. First we add the first 2, then we remove it, and we add the second 2. And that's how we get the `[1,2]` duplicates. Same situations for the duplicated `[2]`.

When seeing `nums[i] == nums[i-1]` in the if-statement, somebody may worry that `[2,2]` will be excluded from the results. But it won't. Let's see how we get the `[2,2]` in the above illustration:
> First we add a 2 to the current candidate set (`curr` in our case), and then we move to the next level to add the second 2. The two number 2s are not in the same level, so `nums[i] == nums[i-1]` will not excluded `[2,2]`.

Last but not least, to use `nums[i] == nums[i-1]`, the prerequisite is that the given numbers are **sorted**. Only when the numbers are in order, duplicate numbers are positioned next to each other.
