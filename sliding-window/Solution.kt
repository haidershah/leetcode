/**
    Time - O(n)
    Space - O(1)

    n - number of elements
 */
class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        
        var sum = 0.0
        for(i in 0..k - 1) {
            sum += nums[i]
        }

        var avg = sum / k

        for(i in 1..nums.size - k) {
            sum = sum - nums[i - 1]
            sum = sum + nums[i + k - 1]

            var newAvg = sum / k
            avg = Math.max(avg, newAvg)
        }

        return avg
    }
}

