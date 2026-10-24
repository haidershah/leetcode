/**
    Time - O(n^2 * m)
    Space - O(m)

    n - number of elements
    m - number of digits

    https://leetcode.com/problems/count-almost-equal-pairs-i/?utm_source=chatgpt.com$0
 */
class Solution {
    fun countPairs(nums: IntArray): Int {
        var count = 0

        for(i in 0..nums.size - 1) {
            for (j in i+1..nums.size - 1) {
                val num1 = nums[i]
                val num2 = nums[j]

                if(areAlmostEqual(num1, num2)) {
                    count++
                }
            }
        }

        return count
    }

    fun areAlmostEqual(num1: Int, num2: Int): Boolean {
        if(num1 == num2) return true

        val num1StrBuilder = StringBuilder(num1.toString())
        val num2StrBuilder = StringBuilder(num2.toString())

        // pad 0s to smaller number
        if(num1StrBuilder.length < num2StrBuilder.length) {
            val numZeros = num2StrBuilder.length - num1StrBuilder.length
            num1StrBuilder.insert(0, "0".repeat(numZeros))
        } else if(num2StrBuilder.length < num1StrBuilder.length) {
            val numZeros = num1StrBuilder.length - num2StrBuilder.length
            num2StrBuilder.insert(0, "0".repeat(numZeros))
        }

        val indices = mutableListOf<Int>()

        for(i in 0..num1StrBuilder.length - 1) {
            if(num1StrBuilder[i] != num2StrBuilder[i]) {
                indices.add(i)
            }
        }

        if(indices.size != 2) {
            return false
        }

        if(num1StrBuilder[indices[0]] == num2StrBuilder[indices[1]] && num2StrBuilder[indices[0]] == num1StrBuilder[indices[1]]) return true

        return false
    }
}

