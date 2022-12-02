package aoc.day02

import java.io.File

fun main() {
    val rounds = File("src", "main/resources/day02.txt").readLines()
        .map {
            val pairs = it.split(' ')
            Pair(pairs[0], pairs[1])
        }

    var partOneScore = 0
    rounds.forEach {
        when (it.second) {
            "X" -> { partOneScore += 1 }
            "Y" -> { partOneScore += 2 }
            "Z" -> { partOneScore += 3 }
        }

        val move = Move.find(it.first)!!
        if (it.second == move.winningMove) {
            partOneScore += 6
        } else if (it.second == move.matching) {
            partOneScore += 3
        }
    }

    var partTwoScore = 0
    rounds.forEach {
        when (it.second) {
            "X" -> {
                val winningMove = Move.find(it.first)?.winningMoveActual
                val moveSet = mutableListOf("A", "B", "C")
                moveSet.removeAll(setOf(it.first, winningMove))
                partTwoScore += Move.find(moveSet.first())!!.points
            }
            "Y" -> {
                partTwoScore += Move.find(it.first)!!.points
                partTwoScore += 3
            }
            "Z" -> {
                val winningMove = Move.find(it.first)?.winningMoveActual
                partTwoScore += Move.find(winningMove!!)!!.points
                partTwoScore += 6
            }
        }
    }

    println(partOneScore) //11386
    println(partTwoScore) //13600
}



enum class Move(val winningMoveActual: String, val points: Int, val winningMove: String, val matching: String) {
    A("B", 1, "Y", "X"),
    B("C", 2, "Z", "Y"),
    C("A", 3, "X", "Z");

    companion object {
        fun find(name: String): Move? {
            return Move.values().find { it.name == name }
        }
    }
}