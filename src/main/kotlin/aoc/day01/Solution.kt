package aoc.day01

import java.io.File

fun main() {
    val elvesCals = File("src", "main/resources/day01.txt").readText()
        .split("\n\n")
        .map { it.lines().sumOf(String::toInt) }
        .sortedDescending()

    println(elvesCals.first())
    println(elvesCals[0] + elvesCals[1] + elvesCals[2])
}
