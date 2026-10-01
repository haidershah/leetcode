/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * 
 * Time - O(n)
 * Space - O(1)
 *
 * n - number of items
 * 
 * https://leetcode.com/problems/reverse-linked-list/$0
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {

        // no items
        if(head == null) {
            return null
        } else if(head.next == null) { // 1 item
            return head
        }

        var prev: ListNode? = null
        var current: ListNode? = head
        var next: ListNode? = current?.next

        while(next != null) {
            current?.next = prev
            prev = current
            current = next
            next = next?.next
        }

        current?.next = prev

        return current
    }
}

