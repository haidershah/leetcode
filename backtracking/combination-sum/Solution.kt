/**
    Time - O(n^h * (n + h))
    Space - O(n^h * h)

    n - number of candidates
    h - height of tree: target / smallest number
 */
class Solution {
    val result = mutableListOf<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        result.clear()

        dfs(candidates, target, 0, 0, mutableListOf())

        return result
    }

    fun dfs(candidates: IntArray, target: Int, index: Int, currentSum: Int, currentList: MutableList<Int>) {
        if(currentSum == target) {
            result.add(currentList.toList())
            return
        } else if (currentSum > target) {
            return
        }

        for(i in index..candidates.size - 1) { // index = 0, i = 0..3
            val num = candidates[i]
            currentList.add(num)
            
            dfs(candidates, target, i, currentSum + num, currentList)

            currentList.removeAt(currentList.lastIndex)
        }
    }
}

