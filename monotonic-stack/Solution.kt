/**
    Time - O(n * m)
    Space - O(n)

    n - Number of items in nums1
    m - Number of items in nums2

    https://leetcode.com/problems/next-greater-element-i/$0
 */
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val result: IntArray = IntArray(nums1.size)

        for(i in 0..nums1.size - 1) {
            val num1 = nums1[i]
            var isNumFound = false
            var isResultFound = false

            for(num2 in nums2) {
                if(isNumFound) {
                    if (num2 > num1) {
                        result[i] = num2
                        isResultFound = true
                        break
                    }
                } else {
                    if(num1 == num2) {
                        isNumFound = true
                    }
                }
            }

            if(!isResultFound) {
                result[i] = -1
            }
        }

        return result
    }
}

