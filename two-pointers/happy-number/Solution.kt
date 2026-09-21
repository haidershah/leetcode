/**
    Time - O(log d)
    Space - O(1)

    d - number of digits

    https://leetcode.com/problems/happy-number
 */
class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = n

        while(slow != 1 || fast != 1 || slow != fast) {
            slow = transform(slow)
            fast = transform(transform(fast))

            if(slow == 1 || fast == 1) {
                return true
            }

            if(slow == fast) {
                return false
            }
        }

        return true
    }

    fun transform(n: Int): Int {
        var number = n
        var result = 0

        while(number != 0) {
            val digit = number % 10
            result += digit * digit
            number = number / 10
        }

        return result
    }
}

