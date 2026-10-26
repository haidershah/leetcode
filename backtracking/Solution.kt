/**
    Time - O(n^2 * n!)
    Space - O(n * n!)

    n - number of elements

    https://leetcode.com/problems/permutations/$0
 */
class Solution {
    val result = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        result.clear()

        dfs(nums, mutableListOf<Int>())

        return result
    }

    fun dfs(nums: IntArray, current: MutableList<Int>) {
        if(current.size == nums.size) {
            result.add(current.toList())
            return
        }

        for(num in nums) {
            if(!current.contains(num)) {
                current.add(num)
                dfs(nums, current)
                current.removeAt(current.lastIndex)
            }
        }
    }
}

