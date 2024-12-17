package _2024

import java.io.File

fun one(inputIntLists: List<List<Int>>) {
    val result = inputIntLists.count { inOrder(it) }
    println(result)
}

fun two(inputIntLists: List<List<Int>>) {
    var result = inputIntLists.count { inOrder(it) }
    result += inputIntLists.filter { list -> !inOrder(list) }.count { list ->
        list.indices
            .any {
                val tempList = list.toMutableList()
                tempList.removeAt(it)
                inOrder(tempList)
            }
    }
    println(result)
}

private fun inOrder(inputIntList: List<Int>): Boolean {
    if (inputIntList.size < 2) {
        return true
    }
    val differences = inputIntList.zipWithNext { a, b -> b - a }

    val increasing = differences.all { it in 1..3 }
    val decreasing = differences.all { it in -3..-1 }
    return increasing || decreasing
}

fun main() {
    val inputIntLists = File("inputs/2024/2024-02.txt").readLines().map { line ->
        line.split(" ").map { it.toInt() }
    }
    one(inputIntLists)
    two(inputIntLists)
}