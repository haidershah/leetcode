/**
    Time - O(n + m)
    Space - O(n + m)

    n - Number of items in nums1
    m - Number of items in nums2

    https://leetcode.com/problems/next-greater-element-i/$0
 */
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val map = mutableMapOf<Int, Int>()

        for (num in nums2) {
            while(stack.isNotEmpty() && num > stack.last()) {
                map[stack.removeLast()] = num
            }
            stack.addLast(num)
        }

        while(stack.isNotEmpty()) {
            map[stack.removeLast()] = -1
        }

        val result = IntArray(nums1.size)

        for(i in nums1.indices) {
            result[i] = map[nums1[i]] ?: -1
        }

        return result
    }

    /**
        Time - O(n * m)
        Space - O(n)

        n - Number of items in nums1
        m - Number of items in nums2
     */
    fun approachA(nums1: IntArray, nums2: IntArray): IntArray {
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

