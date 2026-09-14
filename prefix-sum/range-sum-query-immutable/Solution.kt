class NumArray(nums: IntArray) {

    val prefixSum = IntArray(nums.size)

    /**
    Time - O(n)
    Space - O(n)

    n - number of elements
     */
    init {
        var currentSum = 0

        for (i in nums.indices) {
            currentSum += nums[i]

            prefixSum[i] = currentSum
        }
    }

    /**
    Time - O(1)
    Space - O(1)

    n - number of elements
     */
    fun sumRange(left: Int, right: Int): Int {
        var leftSum = if(left == 0) 0 else prefixSum[left - 1]
        var rightSum = prefixSum[right]

        return rightSum - leftSum
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
