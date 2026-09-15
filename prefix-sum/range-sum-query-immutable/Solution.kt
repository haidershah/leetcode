/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray(nums: IntArray) {

    val prefixSum = IntArray(nums.size + 1)

    /**
        Time - O(n)
        Space - O(n)

        n - number of elements
     */
    init {
        prefixSum[0] = 0

        for (i in 0..nums.size - 1) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]
        }
    }

    /**
        Time - O(1)
        Space - O(1)

        n - number of elements
     */
    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right + 1] - prefixSum[left]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
