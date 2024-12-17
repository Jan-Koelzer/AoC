package _2024

import java.io.File
import kotlin.math.abs

fun one(intLeftSide: List<Int>, intRightSide: List<Int>): Int {
    val sortedLeft = intLeftSide.sorted()
    val sortedRight = intRightSide.sorted()

    return sortedLeft.zip(sortedRight) { left, right ->
        abs(left - right)
    }.sum()
}

fun two(intLeftSide: List<Int>, intRightSide: List<Int>): Int {
    val countValuesOfRight = intRightSide.groupingBy { it }.eachCount()

    return intLeftSide.sumOf { countValuesOfRight[it]?.times(it) ?: 0 }
}

fun main() {
    val (intLeftSide, intRightSide) = File("inputs/2024/2024-01.txt").readLines().map { line ->
        val (left, right) = line.split("   ").map { it.toInt() }
        left to right
    }.unzip()
    println(one(intLeftSide, intRightSide))
    println(two(intLeftSide, intRightSide))
}