class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        if m > n:
            nums1, nums2 = nums2, nums1
            m, n = n, m
        left = 0  # 0 element on the left side of 'left'
        right = m  # m elments on the left side of 'right'
        half_len = (m + n + 1) // 2
        while left <= right:
            i = (left + right) // 2  # after the partition, i elements for one group
            j = half_len - i  # j elements for another group
            if i > 0 and nums1[i-1] > nums2[j]:
                # i is too big, then we decrease it
                right = i - 1
            elif i < m and nums1[i] < nums2[j-1]:
                # i is too small, then we increase it
                left = i + 1
            else:
                if i == 0:  # it means in the final partition, no element in nums1 is included on the left
                    left_max = nums2[j-1]
                elif j == 0:
                    left_max = nums1[i-1]
                else:
                    left_max = max(nums1[i-1], nums2[j-1])
                
                if (m + n) % 2 == 1:
                    return left_max
                
                if i == m:  # it means in the final partition, all elements in nums1 are included on the left
                    right_min = nums2[j]
                elif j == n:
                    right_min = nums1[i]
                else:
                    right_min = min(nums1[i], nums2[j])
                    
                return (left_max + right_min) / 2
