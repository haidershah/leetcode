/**
    Time - O(n)
    Space - O(k)

    n - number of elements
    k - distinct characters

    https://leetcode.com/problems/longest-substring-without-repeating-characters/$0
*/
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }

        var length = 1

        var left = 0
        var right = left + 1

        val set = HashSet<Char>()
        set.add(s[left])

        while(right < s.length) {
            if(set.contains(s[right])) {
                set.remove(s[left])
                left++
            } else {
                set.add(s[right])
                length = Math.max(length, right - left + 1)
                right++
            }
        }

        return length
    }
}

