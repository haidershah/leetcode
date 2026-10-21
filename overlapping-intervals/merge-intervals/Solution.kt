class Solution {

    /**
        Time - O(n log n)
        Space - O(n)

        n - Number of intervals

        https://leetcode.com/problems/merge-intervals/$0
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged = mutableListOf<IntArray>()

        // sort by start-time
        intervals.sortBy { it[0] }

        for(interval in intervals) {
            if(merged.isEmpty()) {
                merged.add(interval)
            } else {
                val intervalA = merged.last() // last item

                // is overlapping
                if(interval[0] <= intervalA[1]) {
                    intervalA[1] = Math.max(intervalA[1], interval[1])
                } else { // not overlapping
                    merged.add(interval)
                }
            }
        }

        return merged.toTypedArray()
    }
}

