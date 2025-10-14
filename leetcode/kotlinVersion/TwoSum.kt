package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 14, October 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to the target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * </pre>
 * </blockquote>
 */


// TC -> O(n), SC -> O(n)
fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf()
    }

    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }

    return intArrayOf()
}

// TC -> O(n^2), SC -> O(1)
fun twoSumII(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf()
    }

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf()
}


