/**

    Time - O(n * log k)
    Space - O(k)

    n - number of elements

    https://leetcode.com/problems/kth-largest-element-in-an-array/$0
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()

        // 3, 2
        for(i in 0..k - 1) {
            minHeap.add(nums[i])
        }

        // 1, 5, 6, 4
        for(i in k..nums.size - 1) {
            val num = nums[i]

            if(num > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(num)
            }
        }

        return minHeap.poll()
    }
}

