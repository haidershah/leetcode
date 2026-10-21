/**
    Time - O(log n)
    Space - O(1)

    n - number of elements in array

    https://leetcode.com/problems/search-in-rotated-sorted-array/$0
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1

        while(left <= right) {
            val middle = (left + right) / 2

            if(nums[middle] == target) {
                return middle
            }

            // left part is sorted
            if(nums[left] <= nums[middle]) {
                // move left
                if(target >= nums[left] && target <= nums[middle]) {
                    right = middle - 1
                } else {
                    left = middle + 1
                }
            } else { // right part is sorted
                if(target >= nums[middle] && target <= nums[right]) {
                    left = middle + 1
                } else {
                    right = middle - 1
                }
            }
        }

        return -1
    }
}

