/**
    Time - O(r * c)
    Space - O(r * c)

    r - number of rows
    c - number of columns

    https://leetcode.com/problems/rotting-oranges/$0
 */
class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var numIterations = 0

        val queue = ArrayDeque<Orange>()

        // find rotten oranges
        for(r in grid.indices) {
            for(c in grid[0].indices) {
                if(grid[r][c] == 2) {
                    queue.addLast(Orange(r, c, 0))
                }
            }
        }

        while(queue.isNotEmpty()) {
            val orange = queue.removeFirst()
            numIterations = Math.max(numIterations, orange.height)

            for(neighbor in getNeighbors(grid, orange)) {
                queue.addLast(neighbor)
                grid[neighbor.r][neighbor.c] = 2
            }
        }

        // if any fresh oranges left (1), return -1
        for(r in grid.indices) {
            for(c in grid[0].indices) {
                if(grid[r][c] == 1) {
                    return -1
                }
            }
        }

        return numIterations
    }

    fun getNeighbors(grid: Array<IntArray>, orange: Orange): MutableList<Orange> {
        val neighbors = mutableListOf<Orange>()

        val row = orange.r
        val col = orange.c
        val h = orange.height

        if(col - 1 in grid[0].indices && grid[row][col - 1] == 1) {
            neighbors.add(Orange(row, col - 1, h + 1))
        }

        if(row - 1 in grid.indices && grid[row - 1][col] == 1) {
            neighbors.add(Orange(row - 1, col, h + 1))
        }

        if(col + 1 in grid[0].indices && grid[row][col + 1] == 1) {
            neighbors.add(Orange(row, col + 1, h + 1))   
        }
        
        if(row + 1 in grid.indices && grid[row + 1][col] == 1) {
            neighbors.add(Orange(row + 1, col, h + 1))   
        }

        return neighbors
    }
}

data class Orange(val r: Int, val c: Int, val height: Int)
