>[Click here to check](https://leetcode.com/problems/intersection-of-two-linked-lists/)

Solution:  
this is a little difficult. We can solve an easier version and then find a general pattern to solve all situations. In an easy case, say there is an intersection and both paths (e.g. A path and B path) have a same length. In such a case, we keep moving one step on A path and one step on B path, and we compare the nodes. And we do this over and over again. Eventually the next nodes will be the same, since they have intersection, and the path before they intersect have a same length.

Now we can think of a general-er case. What if they don't have intersection? Answer is the nodes can still be the same. Both are null, null == null is true.

What if path A and path B have different lengths? Well, think of two people walking on A and B, respectively. Can we make them meet (since we visit one node one step, their walking speed should be the same)? Yes, we can! Say Zheng walks on path A and Gyumin walks on path B (the path C after intersection is shared so we ignore it), if path A is shorter, Zheng can continue to walk on path B; and when Gyumin finished path B, he can walk on path A.

`len(A)` may not equal to `len(B)`, but `len(A)` + `len(B)` == `len(B)` + `len(A)` is always true. Therefore they will always meet at the intersection point if they all walk on both path A and path B.
