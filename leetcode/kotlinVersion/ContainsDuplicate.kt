package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 16, September 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * 1 <= nums.length <= 10^5-10^9 <= nums[i] <= 10^9
 *
 * </pre>
 * </blockquote>
 */


// TC -> O(n^2), SC -> O(1)
fun containsDuplicate(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) return true
        }
    }
    return false
}

// TC -> O(nlogn), SC -> O(1)
fun containsDuplicateII(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    nums.sort()
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1]) return true
    }
    return false
}

// TC -> O(n), SC -> O(n)
fun containsDuplicateIII(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    val uniqueNumbers = mutableSetOf<Int>()
    for (num in nums) {
        if (uniqueNumbers.contains(num)) {
            return true
        }
        uniqueNumbers.add(num)
    }
    return false
}

// TC -> O(n), SC -> O(n)
fun containsDuplicateIV(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    val uniqueNumbers = mutableSetOf<Int>()
    for (num in nums) {
        if (!uniqueNumbers.add(num)) {
            return true
        }
    }
    return false
}

// TC -> O(n), SC -> O(n)
fun containsDuplicateV(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    val uniqueNumbers = mutableSetOf<Int>()
    for (num in nums) {
        uniqueNumbers.add(num)
    }

    return uniqueNumbers.size < nums.size
}

// TC -> O(n), SC -> O(n)
fun containsDuplicateVI(nums: IntArray): Boolean {
    if (nums.isEmpty()) return false

    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        if (map.containsKey(num)) {
            return true
        }
        map.put(num, 1)
    }
    return false
}
