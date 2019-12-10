>[Click here to check](https://leetcode.com/problems/two-sum/)

Solution:  
the very first thought is brute force, we can use nested for-loop to achieve it, check `solution0.py` for a brute force solution. If we think for a while, we notice that, we can traverse the list, for each number, we check if (target - current_number) is inside the list. If it is in, then we get its index. A look-up table using hashmap only costs O(1) time for look-up. So we can build a look-up table first, and then check if (target - current_number) is in. Now the solution is O(n), check `solution1.py`. We should notice that one number can only be used once, so we have to make sure that both index are not same.

In the above O(n) method, we do it in two passes. However, we can do everything in just one pass.
We can build the look-up table while checking if (target - current_number) is inside the list. Since we do the check first and then put current_number in the look-up table, we don't need to worry about the reuse of a number. Check `solution2.py` for it.
