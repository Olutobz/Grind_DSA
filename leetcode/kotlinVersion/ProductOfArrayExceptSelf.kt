package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 23, October 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an integer array nums, return an array answer such that answer[i] is equal
 * to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 * </pre>
 * </blockquote>
 */


// TC -> O(n^2), SC -> O(n)
fun productExceptSelf(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val result = IntArray(nums.size)
    for (i in 0 until nums.size) {
        var product = 1
        for (j in 0 until nums.size) {
            if (nums[i] == nums[j]) continue
            product *= nums[j]
        }
        result[i] = product
    }

    return result
}

// TC -> O(n), SC -> O(n)
fun productExceptSelfII(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val n = nums.size
    val result = IntArray(n)
    val prefix = IntArray(n)
    val suffix = IntArray(n)

    prefix[0] = 1
    for (i in 1 until n) {
        prefix[i] = nums[i - 1] * prefix[i - 1]
    }

    suffix[n - 1] = 1
    for (i in n - 2 downTo 1) {
        suffix[i] = nums[i + 1] * suffix[i + 1]
    }

    for (i in 0 until n) {
        result[i] = prefix[i] * suffix[i]
    }

    return result
}