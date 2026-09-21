/**
    Time - O(n + m)
    Space - O(1)

    n - characters in s
    m - characters in t

    https://leetcode.com/problems/minimum-window-substring/$0
 */
class Solution {
    fun minWindow(s: String, t: String): String {
        var leftResult = 0
        var rightResult = 0
        var resultLength = s.length
        var left = 0
        var right = left
        var wasValidWindowFound = false

        // number of characters matched (in terms of frequency) between t and s
        var numMatched = 0

        // create t-map
        val tMap = mutableMapOf<Char, Int>()
        for(c in t) {
            var frequency = tMap.get(c) ?: 0
            tMap.put(c, ++frequency)
        }

        // create s-map
        val sMap = mutableMapOf<Char, Int>()
        if(!s.isEmpty() && s.length >= 1) {
            val c = s[0]
            var frequency = sMap.get(c) ?: 0
            sMap.put(c, ++frequency)

            if(doesCharFreqMatch(c, sMap, tMap)) {
                numMatched++
            }
        }

        while(right < s.length) {
            while(right < s.length && numMatched != tMap.keys.size) {
                right++

                if(right < s.length) {
                    val c = s[right]
                    var freq = sMap[c] ?: 0
                    sMap.put(s[right], ++freq)

                    if(doesCharFreqMatch(c, sMap, tMap)) {
                        numMatched++
                    }
                }
            }

            if(numMatched == tMap.keys.size) {
                wasValidWindowFound = true
            }

            if(right == s.length) {
                break
            }

            val substringLength = right + 1 - left
            if(substringLength <= resultLength) {
                leftResult = left
                rightResult = right
                resultLength = rightResult + 1 - leftResult
            }

            val removedChar = s[left]

            var wasMatching = false
            if(doesCharFreqMatch(removedChar, sMap, tMap)) {
                wasMatching = true    
            }

            var freq = sMap[removedChar] ?: 0
            sMap.put(removedChar, --freq)

            if(wasMatching && !doesCharFreqMatch(removedChar, sMap, tMap)) {
                numMatched--
            }

            left++
        }

        if(wasValidWindowFound) {
            return s.substring(leftResult, rightResult + 1)
        } else {
            return ""
        }
    }

    fun doesCharFreqMatch(c: Char, sMap: MutableMap<Char, Int>, tMap: MutableMap<Char, Int>): Boolean {
        return (tMap[c] ?: 0) == (sMap[c] ?: 0)
    }
}

