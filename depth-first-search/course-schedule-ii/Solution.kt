/**

    Time - O(V + E)
    Space - O(V + E)

    V - number of vertices
    E - number of edges

    https://leetcode.com/problems/course-schedule-ii/$0
 */
class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()

        // Setup adjacency list
        val adjList = Array<MutableList<Int>>(numCourses) { mutableListOf<Int>() }

        // Setup initial indegrees
        val indegrees = IntArray(numCourses)
        
        for (prereq in prerequisites) {
            val from = prereq[1]
            val to = prereq[0]

            indegrees[to]++
            adjList[from].add(to)
        }

        // // Add all vertices with indegree 0 to queue
        val queue = ArrayDeque<Int>()
        for(i in 0..numCourses - 1) {
            if(indegrees[i] == 0) {
                // println("Add indegree: $indegree")
                queue.addLast(i)
            }
        }

        while(queue.isNotEmpty()) {
            // Add the vertex to result after popping it from the queue
            val dequeuedVertex = queue.removeFirst()
            result.add(dequeuedVertex)

            // When a vertex is popped, decrement its neighbors' indegrees
            for(neighbor in adjList[dequeuedVertex]) {
                indegrees[neighbor]--

                // Add a neighbor to queue only when its indegree becomes 0
                if(indegrees[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        // Return result if all vertices processed, otherwise empty array
        return if(result.size == numCourses) {
            result.toIntArray()
        } else {
            intArrayOf()
        }
    }
}

