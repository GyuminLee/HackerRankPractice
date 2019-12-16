>[Click here to check](https://leetcode.com/problems/subsets/)

Solution:  
I hate to say this, but this is a standard backtracking problem, normally you need to "memorize" a code template for it. Here I'll try my best to explain how this template works.

First, backtracking is a group of problems, where you need to find **all** possible cases that meet particular requirements. In this problem, we need to find all possible subsets given a list of numbers.

```python
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
```

In func `dfs()`, we need four parameters:

1. One of them should be **the results we need to return**, in this code snippet we call it `results`.
2. One of them should be **a possible candidate of the final results**, for example, we want to get all subsets of [1,2,3], then [1,2] is a possible candidate, [1] is also a possible candidate. In this code snippet, we call it `curr`, which is short for *the current candidate*.
3. Apparently, we should pass the `nums` itself, which is the given input.
4. Last but not least, we need to pass a starting index (`start` in this snippet), to indicate where we are, which element we are currently dealing with, to help the recursive process.


Let's go back and dive into this problem of generating subsets:  
we initialize `curr`, which is the current candidate to `[]`. An empty set is also a subset a the given `nums`. And we initialize the `start` to 0, as we start from the first element in the given `nums`.

Now we focus on the `dfs()` function above. Since it's a recursive function, normally we write a if-statement as a termination case. Here we should write `if start == len(nums): return`. When it evaluates True, it means we have dealed with all elements in the given set. So we can stop and return now. However in this case, the for loop will terminate itself when the value of `start` is equal to `len(nums)`, therefore we can omit the if-statement here.

We now add `curr` to our final results. Note that in fact, we add a shallow copy of `curr` instead of `curr` itself. This is because `curr` here is a container (a `list` in this case). If we add the container itself, the content may get changed in later steps. But this is not acceptable in our situation. Since in our situation, what really matters is the contents inside the container, not the container itself. Right now we need to add empty set in the final results. So in the final results, the first element will be a `[]`. But if we didn't use a shallow copy, we use the container itself. The first element in the final results cannot be a `[]`. And the results are wrong.

In the for-loop, we traverse all possible index, which is actually visiting each element one by one in the given set. We add element nums[i] in `curr`, call the recursive function itself, to find all possible subsets of nums with element nums[i] inside. Then, we delete the element nums[i] in `curr`, to backtracking all the possible results that don't contain nums[i]. In other words, we try to find all possible subsets with the element nums[i] in them, and without the element nums[i] in them. Note that in the recursive call, we need to increase the starting index by 1, to move on to the next element in the given set.


Time Complexity Analysis:  
O(n*2^n)  
for each element in the given `nums`, we can include it in the subset or not include it. So we have two choices for each element. And there are n elements. Therefore we have `2^n`. As for `n`, it comes from the shallow copy in the code snippet.
