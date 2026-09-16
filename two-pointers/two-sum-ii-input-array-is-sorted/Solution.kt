/**
    Time - O(n)
    Space - O(1)

    n - number of elements

    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/$0
 */
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        var l = 0
        var r = numbers.size - 1

        while(l < r) {
            val sum = numbers[l] + numbers[r]

            // equal
            if(sum == target) {
                return intArrayOf(l + 1, r + 1)
            } else if(sum < target) {
                l++
            } else { // target > sum
                r--
            }
        }

        return intArrayOf()
    }
}

