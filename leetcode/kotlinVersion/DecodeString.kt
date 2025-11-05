package kotlinVersion

import java.util.*

fun decodeString(s: String?): String {
    if (s.isNullOrEmpty()) return ""

    val intStack = Stack<Int>()
    val strStack = Stack<StringBuilder>()
    var res = StringBuilder()
    var k = 0

    for (ch in s) {
        when {
            ch.isDigit() -> {
                k = k * 10 + (ch - '0')
            }

            ch == '[' -> {
                intStack.push(k)
                strStack.push(res)
                res = StringBuilder()
                k = 0
            }

            ch == ']' -> {
                val temp = res
                res = strStack.pop()
                repeat(intStack.pop()) {
                    res.append(temp)
                }
            }

            else -> {
                res.append(ch)
            }
        }
    }

    return res.toString()
}