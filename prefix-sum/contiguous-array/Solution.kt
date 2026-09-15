/**
 * https://leetcode.com/problems/contiguous-array/
 */
class Solution {
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0

        // prefixSum -> firstIndex
        val map = mutableMapOf<Int, Int>()

        // create prefix sum array
        val prefix = IntArray(nums.size + 1)
        prefix[0] = 0
        map.put(prefix[0], 0)

        for (i in 0..nums.size - 1) {
            val num = if (nums[i] == 0) -1 else 1
            prefix[i + 1] = prefix[i] + num

            // if exists
            if(map[prefix[i + 1]] != null) {
                val currMaxLength = (i + 1) - (map[prefix[i + 1]] ?: 0)
                maxLength = Math.max(maxLength, currMaxLength)
            } else { // .. NOT exists
                map.put(prefix[i + 1], i + 1)
            }
        }

        return maxLength
    }
}

