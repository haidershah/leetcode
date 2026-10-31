/**
    Time - O(n * 2^n)
    Space - O(k * n C k)

    https://leetcode.com/problems/combinations/$0
 */
class Solution {
    val result = mutableListOf<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        result.clear()
        
        dfs(n, k, 1, mutableListOf())

        return result
    }

    fun dfs(n: Int, k: Int, currentNum: Int, currentList: MutableList<Int>) {
        if(currentList.size == k) {
            result.add(currentList.toList())
            return
        }

        for(num in currentNum..n) { // num = 1..4
            currentList.add(num)
            dfs(n, k, num + 1, currentList)
            currentList.removeAt(currentList.lastIndex)
        }
    }
}

