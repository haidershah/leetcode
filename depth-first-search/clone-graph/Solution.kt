/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 * 
 * Time - O(V + E)
 * Space - O(V + E)
 *
 * V - number of vertices
 * E - number of edges
 *
 * https://leetcode.com/problems/clone-graph/description/$0
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {

        // empty graph
        if(node == null) return null

        // graph contains one node with no neighbors
        if(node.neighbors.isEmpty()) return Node(node.`val`)

        val map = mutableMapOf<Int, Node>()

        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        while(queue.isNotEmpty()) {
            val removedNode = queue.removeFirst()

            // process node
            val newNode = map.getOrPut(removedNode.`val`) {
                Node(removedNode.`val`)
            }

            for(neighbor in removedNode.neighbors) {
                if(neighbor == null) continue

                val newNeighbor = map.getOrPut(neighbor.`val`) {
                    queue.addLast(neighbor)
                    Node(neighbor.`val`)
                }

                newNode.neighbors.add(newNeighbor)
            }
        }

        return map[node.`val`]
    }
}

