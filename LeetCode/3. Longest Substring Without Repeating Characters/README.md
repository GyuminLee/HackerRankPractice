>[Click here to check](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Solution:  
first we think of brute force. We list all substrings of the given string, and check if there are duplicates characters. If there is not, we record the length. And we keep updating the length until we've tested all substrings. But it is not efficient. Here is why:  

e.g. for `abbdef`, some substrings could be, `a`, `ab`, `abb`, `abbd`, `abbde`, `abbdef`. In `abb` we found duplicates. Now we don't need to check any other substrings that starts with `abb`, in the above case, we don't need to check `abbd`, `abbde`, `abbdef`, since they contain `abb` and cannot be valid. Inspired by this observation, we can have a new idea, which is called Sliding Window.

We maintain two pointers, `left` and `right`. `left` stays at the beginning and `right` keeps moving forward. When moving, we put all elements we met into a HashSet, for the purpose of look-up. In each step we check the character pointed by `right`, we check it in the look-up hashset, if the character is inside the hashset, it means we have duplicates. Then we do not start in the original beginning. We move the `left` pointer one step to the right. Make sure you delete the character pointed by the `left` pointer from the hashset before you move the `left` pointer.

We can still improve it. Think of how we did after finding duplicates: we move the `left` pointer one step to the right. Actually, even though we move it one step, the duplicates may still exist.  

For example, in string `efabcdabc`, at some point, `left` is pointing to `e`, `right` is pointing to the second `a`. We found that `a` is duplicated, then we move `left` one step forward, delete `e` from the visited set. And now `left` is pointing to `f`. We can clearly see that `fabcda` still have duplicated `a`. Then we continue to move `left` forward until the first occurance of the duplicated `a` is excluded.

This is where we can make an improvement. If we know where is the location of the first occurance of the duplicated elements, we can set the new `left` pointer to the right neighbor of the first occurance of the duplicated elements. In the above example, this means we should set `left` with the position of the first `b` in the string, which is 3. To achieve this we need a HashMap instead of a HashSet to save the positions as well.

We need to pay attention to the implementation of the optimized version of code. Since in previous simpler version, each time we only move the pointer one step - we check the pointed element and we exclude the pointed element. In the optimized version, the pointer can skip over many elements inbetween. Therefore when we consider to delete the elements as above, we need to delete all elements inbetween, not just what we were pointed to. The reason is all elements before the `left` pointer are definitely not included in the possible solutions of substrings, they should not be considered as visited elements. We can create a new empty HashMap to do this, as it's done in `a_not_so_good_solution.py`. The flaw is memory inefficient.

We can avoid create a new empty HashMap by a simple trick. Check the java version solution for details.
