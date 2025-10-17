package kotlinVersion

import java.util.*

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 15, October 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * <blockquote>
 * <pre>
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * Output: [1,2]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 * </blockquote>
 */


// TC -> O(n), SC -> O(n)
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    if (k == nums.size) return nums

    val freqMap = mutableMapOf<Int, Int>()
    for (num in nums) {
        freqMap[num] = freqMap.getOrDefault(num, 0) + 1
    }

    val bucketArr = Array(nums.size + 1) { mutableListOf<Int>() }
    for ((num, freq) in freqMap) {
        bucketArr[freq].add(num)
    }

    val result = mutableListOf<Int>()
    for (i in bucketArr.size - 1 downTo 1) {
        for (num in bucketArr[i]) {
            if (result.size == k) return result.toIntArray()
            result.add(num)
        }
    }

    return result.toIntArray()
}

// TC -> O(n log k), SC -> O(n + k)
fun topKFrequentII(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    if (k == nums.size) return nums

    val freqMap = mutableMapOf<Int, Int>()
    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    val maxHeap = PriorityQueue<Int> { a, b -> freqMap[b]!! - freqMap[a]!! }
    for (currKey in freqMap.keys) {
        maxHeap.offer(currKey)
    }

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = maxHeap.poll()
    }

    return result
}

// TC -> O(n log k), SC -> O(n + k)
fun topKFrequentIII(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val freqMap = mutableMapOf<Int, Int>()
    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    val maxHeap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
    for ((currNum, currFreq) in freqMap) {
        maxHeap.offer(Pair(currNum, currFreq))
    }

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = maxHeap.poll().first
    }

    return result
}

// TC -> O(n log k), SC -> O(n + k)
fun topKFrequentIV(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val freqMap = mutableMapOf<Int, Int>()
    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    for ((currNum, currFreq) in freqMap) {
        minHeap.offer(Pair(currNum, currFreq))
    }

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = minHeap.poll().first
    }

    return result
}

// TC -> O(n log n), SC -> O(n)
fun topKFrequentV(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val freqMap = mutableMapOf<Int, Int>()
    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    val pairList = mutableListOf<Pair<Int, Int>>()
    for ((currNum, currFreq) in freqMap) {
        pairList.add(Pair(currNum, currFreq))
    }
    pairList.sortByDescending { it.second }

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = pairList[i].first
    }

    return result
}