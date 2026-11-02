/**
    Time - O(n)
    Space - O(n)

    https://leetcode.com/problems/climbing-stairs/$0
 */
class Solution {
    var array = intArrayOf()

    fun climbStairs(n: Int): Int {
        array = IntArray(n + 1) { - 1 }

        return dfs(n)
    }

    fun dfs(n: Int): Int {
        if(n == 1) {
            return 1
        } else if (n == 2) {
            return 2
        }

        if(array[n - 1] == -1) {
            array[n - 1] = dfs(n - 1)
        }
        val oneStep = array[n - 1]

        if(array[n - 2] == -1) {
            array[n - 2] = dfs(n - 2)
        }
        val twoStep = array[n - 2]

        return oneStep + twoStep
    }
}

