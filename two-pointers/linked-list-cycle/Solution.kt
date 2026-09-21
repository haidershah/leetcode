/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/**
    Time - O(n)
    Space - O(1)

    n - number of elements
 */
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        if(slow != null && slow.next != null && slow.next.next != null) {
            fast = fast.next.next
        } else {
            return false
        }

        while(slow != null && fast != null && slow.next != null && fast.next != null && slow != fast) {
            slow = slow.next

            if(fast.next.next != null) {
                fast = fast.next.next
            } else {
                return false
            }
        }

        if(slow != null && fast != null && slow == fast) {
            return true
        }

        return false
    }
}

