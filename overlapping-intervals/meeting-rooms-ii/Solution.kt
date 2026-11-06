/**
    Time - O(n log n)
    Space - O(n)

    n - number of intervals

    https://leetcode.com/problems/meeting-rooms-ii/$0
 */
class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val minHeap = PriorityQueue<IntArray>( compareBy<IntArray> { it[1] } )

        // sort intervals by start time
        intervals.sortBy { it[0] }

        for(interval in intervals) {
            // no conflict
            if(minHeap.isNotEmpty() && interval[0] >= minHeap.peek()[1]) {
                minHeap.remove()
            }
            minHeap.add(interval)
        }

        return minHeap.size
    }
}

