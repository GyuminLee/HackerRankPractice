>[Click here to check](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Solution:  
first we think of brute force. We list all substrings of the given string, and check if there are duplicates characters. If there is not, we record the length. And we keep updating the length until we've tested all substrings. But it is not efficient. Here is why:  

e.g. for `abbdef`, some substrings could be, `a`, `ab`, `abb`, `abbd`, `abbde`, `abbdef`. In `abb` we found duplicates. Now we don't need to check any other substrings that starts with `abb`, in the above case, we don't need to check `abbd`, `abbde`, `abbdef`, since they contain `abb` and cannot be valid. Inspired by this observation, we can have a new idea, which is called Sliding Window.

We maintain two pointers, `left` and `right`. `left` stays at the beginning and `right` keeps moving forward. When moving, we put all elements we met into a HashSet, for the purpose of look-up. In each step we check the character pointed by `right`, we check it in the look-up hashset, if the character is inside the hashset, it means we have duplicates. Then we do not start in the original beginning. We move the `left` pointer one step to the right. Make sure you delete the character pointed by the `left` pointer from the hashset before you move the `left` pointer.

We can still improve it. Think of how we did after finding duplicates: we move the `left` pointer one step to the right. Actually, even though we move it one step, the duplicates may still exist. This is where we can improve. If we know where is the location of duplicates, say position=5 and position=current_index, we can actually set the new `left` pointer with position=6. So we skip the first occurance of the duplicates. To achieve this we need a HashMap instead of a HashSet to save the positions as well.

I've implemented both. And it is so weird that my "improved" version behaves much worse than the simpler version. Too weird.
