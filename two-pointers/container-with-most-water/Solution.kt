/**
    Time - O(n)
    Space - O(1)

    n - number of items in array

    https://leetcode.com/problems/container-with-most-water
*/
class Solution {
    fun maxArea(height: IntArray): Int {
        return approachB(height)
    }

    fun approachB(height: IntArray): Int {
        var maxArea = Integer.MIN_VALUE
        var left = 0
        var right = height.size - 1

        while(left < right) {
            val area = Math.min(height[left], height[right]) * (right - left)
            // println("left: $left, right: $right, height[left]: ${height[left]}, height[right]: ${height[right]}, Area: $area")
            maxArea = Math.max(maxArea, area)

            if(height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }

    fun approachA(height: IntArray): Int {
        var maxArea = Integer.MIN_VALUE

        for (i in 0 .. height.size - 1) {
            for(j in i + 1 .. height.size - 1) {
                val area = Math.min(height[i], height[j]) * (j - i)
                maxArea = Math.max(maxArea, area)
            }
        }

        return maxArea
    }
}

