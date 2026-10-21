/**
    Time - O(n * m)
    Space - O(n)

    n - Number of items in nums1
    m - Number of items in nums2

    https://leetcode.com/problems/next-greater-element-i/$0
 */
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val result: IntArray = IntArray(nums1.size) { -1 }

        for(i in nums1.indices) {
            val num1 = nums1[i]
            var isNumFound = false

            for(num2 in nums2) {
                if(isNumFound) {
                    if (num2 > num1) {
                        result[i] = num2
                        break
                    }
                } else {
                    if(num1 == num2) {
                        isNumFound = true
                    }
                }
            }
        }

        return result
    }
}

