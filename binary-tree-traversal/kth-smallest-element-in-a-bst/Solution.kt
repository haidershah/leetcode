/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * 
 * Time - O(h + k)
 * Space - O(h)
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/$0
 */
class Solution {
    var count = 0
    var result = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {

        traverse(root, k)

        return result
    }

    fun traverse(node: TreeNode?, k: Int) {
        if(node == null || count == k) {
            return
        }

        traverse(node.left, k)

        if(count == k) return 

        // process node
        count++
        result = node.`val`

        traverse(node.right, k)
    }
}

