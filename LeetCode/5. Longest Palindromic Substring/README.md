>[Click here to check](https://leetcode.com/problems/longest-palindromic-substring/)

Solution:  
the idea here is center expansion and sliding window. Let's take an example: `s="abcbad"`, first we select a character, then we check the character before and the character after. At the beginning we should start from the first element `s[0]`, but to make the explanation easier to understand, we take an intermediate step (note that this is just to make the explanation easier, in the code you should always start with the first element), say we choose `s[2]` (`c`) here, then we check `s[1]` (the character before) and `s[3]` (the character after), if they are equal (in this case, Yes) then we keep expanding. This time we take `s[1], s[2], s[3]` as a whole: we check the character before this, which is `s[0]`, and then check the character after, which is `s[4]`, if they are equal we keep expanding, otherwise we move on to the next character (this is the so-called sliding window) --- previously we are working on `s[2]`, so now we move on to `s[3]`.

However, in a string like `abbd`, the above technique won't work. The reason is, if you start with one character, and expanding to both ends, the palindromic substring, if exists, can only be of odd length. In `abbd`, the palindromic substring is however of even length. Therefore, we need to make an adjustment for cases when the palindromic substring is even length. Now we choose two adjacent elements in the string, and do the center expansion and sliding window.

For details please check the `solution.py`.
