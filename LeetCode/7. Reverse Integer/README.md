>[Click here to check](https://leetcode.com/problems/reverse-integer/)

Solution:  
this problem is easy, to reverse a integer we need a `pop` operation and a `push` operation, both are showed as below:
```python
# "pop"
pop = x % 10
x /= 10

# "push"
new_rev = rev * 10 + pop
rev = new_rev
```
if the above code snippets are familiar to you now, please check `solution.py` for details.

Other than that, in the description it mentioned that the 32-bit signed integer range is: [-2^31,  2^31 − 1]. Do you know why the number of negatives are one more than the positives? That is because, we use the first bit to represent the sign, 0 for positive and 1 for negative. However, number zero doesn't need a sign. There's no negative zero or positive zero. To fully use the space of computer, we give 10000...0 a different meaning. Since it starts with 1 and 1 is the sign for negatives, we give one more number to the negatives.
