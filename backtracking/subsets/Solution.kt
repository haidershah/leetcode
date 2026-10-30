/**

    Time - O(n * 2^n)
    Space - O(n * 2^n)

    n - number of elements

    https://leetcode.com/problems/subsets/$0
 */
class Solution {
    var result = mutableListOf<List<Int>>()

    fun subsets(nums: IntArray): List<List<Int>> {
        result.clear()

        dfs(nums, 0, mutableListOf())

        return result
    }

    fun dfs(nums: IntArray, start: Int, current: MutableList<Int>) {
        result.add(current.toList())

        for(i in start .. nums.size - 1) {
            current.add(nums[i])
            dfs(nums, i + 1, current)
            current.removeAt(current.size - 1)
        }
    }
}

