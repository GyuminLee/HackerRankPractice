>[Click here to check](https://leetcode.com/problems/min-stack/)

Solution:
the tricky part of this problem is, how to save the minimum value so we can access it in constant time. At first I created a variable to store the min value, but this trick won't work when there exists `pop` operation. If the minimum value is popped out, with this method you cannot know what should be the current min value. Even though you have a second variable to store the second minimum value, how are you gonna update it when the minimum is popped? Apparently this method does not work.

Then we can use extra space to store the current minimum value, which binds to each element inserted.
For details please check the implementation.
