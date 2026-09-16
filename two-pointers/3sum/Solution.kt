/**
    Time - O(n^2)
    Space - O(n)
    
    n - number of elements

    https://leetcode.com/problems/3sum/$0
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<Triplet>()

        nums.sort()

        for(i in 0..nums.size - 3) {
            val tripletSet: Set<Triplet> = twoSum(nums, i)
            set.addAll(tripletSet)
        }

        val result = mutableListOf<List<Int>>()
        for(triplet in set) {
            result.add(listOf(triplet.one, triplet.two, triplet.three))
        }

        return result
    }

    fun twoSum(nums: IntArray, i: Int): Set<Triplet> {
        val set = mutableSetOf<Triplet>()
        var left = i + 1
        var right = nums.size - 1
        val sum = -nums[i]

        while(left < right) {
            if((nums[left] + nums[right]) == sum) {
                set.add(Triplet(nums[i], nums[left], nums[right]))
                left++
                right--
            } else if((nums[left] + nums[right]) > sum) {
                right--
            } else { // (nums[left] + nums[right]) < sum
                left++
            }
        }

        return set
    }

    data class Triplet(
        val one: Int,
        val two: Int,
        val three: Int
    )
}

// nums[left] + nums[right] = -nums[i]

