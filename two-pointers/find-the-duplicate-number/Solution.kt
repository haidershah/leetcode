/**
    Time - O(n)
    Space - O(1)

    n - number of elements

    https://leetcode.com/problems/find-the-duplicate-number/$0
 */
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        while(slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        var newPointer = 0
        while(newPointer != slow) {
            slow = nums[slow]
            newPointer = nums[newPointer]
        }

        return newPointer
    }
}

