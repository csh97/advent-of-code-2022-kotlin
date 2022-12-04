package aoc.day03

import java.io.File


fun main() {
    val input = File("src", "main/resources/day03.txt").readLines()
    val bags = input.map {
        val pairs = it.chunked(it.length / 2)
        Pair(pairs[0].toCharArray().toSet(), pairs[1].toCharArray().toSet())
    }

    val partOne = bags.map { it.first.intersect(it.second) }.sumOf {
        if (it.first().isUpperCase()) {
            it.first().code - 38
        } else {
            it.first().code - 96
        }
    }

    val partTwo = input
        .map { it.toSet() }
        .chunked(3)
        .map { it.first().intersect(it[1]).intersect(it[2]) }
        .sumOf {
            if (it.first().isUpperCase()) {
                it.first().code - 38
            } else {
                it.first().code - 96
            }
        }

    println(partOne)//7716
    println(partTwo)//2973
}