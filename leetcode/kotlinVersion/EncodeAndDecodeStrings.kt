package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 22, October 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 *
 * <blockquote>
 * <pre>
 *
 * Example 1:
 * Input: ["neet","code","love","you"]
 * Output:["neet","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 *
 * Example 2:
 * Input: ["we","say",":","yes"]
 * Output: ["we","say",":","yes"]
 *
 * Constraints:
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 *
 * </pre>
 * </blockquote>
 */


// TC -> O(n), SC -> O(n + m)
fun encode(strs: List<String>): String {
    if (strs.isEmpty()) return ""

    val builder = StringBuilder()
    for (currStr in strs) {
        builder.append(currStr.length).append('#').append(currStr)
    }

    return builder.toString()
}

// TC -> O(n), SC -> O(n + m)
fun decode(str: String): List<String> {
    if (str.isEmpty()) return emptyList()

    val result = mutableListOf<String>()
    var i = 0
    while (i < str.length) {
        var j = i
        while (str[j] != '#') {
            j++
        }
        val currStrLen = str.substring(i, j).toInt()
        i = j + 1
        j = currStrLen + i
        result.add(str.substring(i, j))
        i = j
    }

    return result
}