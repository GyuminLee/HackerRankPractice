>[Click here to check](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

Solution:
The idea is all about finding the peak-valley pattern. In every upward segment, we earn money. As for the limitation of `You may not engage in multiple transactions at the same time`, it doesn't matter at all.
For example, you may find two upward segment in [1, 3, 5], which are `1 to 3` and `3 to 5`, you cannot really do that because you can not sell 3 and buy 3 at the same time. However, (5 - 1) is equal to (3 - 1) + (5 - 3). You are allowed to buy 1 and sell 5. **The results are same**. Therefore we can write lines as below without doubt:

```python
res = 0
for i in range(len(prices) - 1):
    if prices[i] < prices[i + 1]:
        res += prices[i + 1] - prices[i]
```

For a complete solution please check the python file.
