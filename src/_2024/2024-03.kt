package _2024

import java.io.File

fun one(inputString: String) {
    val matches = Regex("""mul\((\d+),(\d+)\)""").findAll(inputString)
    val result = matches.sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
    println(result)
}

fun two(inputString: String) {
    val matches = Regex("""mul\((\d+),(\d+)\)|do\(\)|don't\(\)""").findAll(inputString)
    var on = true
    val result = matches.sumOf {
        if (it.value == "do()") {
            on = true
        } else if (it.value == "don't()") {
            on = false
        }
        if (on && it.groupValues[1].isNotBlank()) {
            it.groupValues[1].toInt() * it.groupValues[2].toInt()
        } else {
            0
        }
    }
    println(result)
}

fun main() {
    val inputString = File("inputs/2024/2024-03.txt").readText()
    one(inputString)
    two(inputString)
}