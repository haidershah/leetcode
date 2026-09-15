/**

    https://leetcode.com/problems/subarray-sum-equals-k/

    Time - O(n)
    Space - O(n)

    n - number of elements in the original array
 */
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0

        val prefix = IntArray(nums.size + 1)
        prefix[0] = 0

        // prefixSum -> frequency
        val map = mutableMapOf<Int, Int>()
        map[0] = 1

        for(i in 0..nums.size - 1) {
            prefix[i + 1] = prefix[i] + nums[i]

            val prefixToFind = prefix[i + 1] - k
            
            // found
            if(map[prefixToFind] != null) {
                count += map[prefixToFind] ?: 0
            }

            // add new prefix sum to map
            var frequence = map[prefix[i + 1]]
            if(frequence != null) {
                frequence++
            } else {
                frequence = 1
            }

            map[prefix[i + 1]] = frequence
        }

        return count
    }
}

