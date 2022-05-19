package com.tw.marsrover

import java.lang.IllegalStateException

class MarsRover(private val x: Int, private val y: Int, private val orientation: String) {

    fun position(): Position {
        return Position(x, y, orientation)
    }

    fun execute(command: String): Position =
        if (orientation == "N") {
            when (command) {
                "R" -> {
                    Position(x, y, "E")
                }
                "L" -> {
                    Position(x, y, "W")
                }
                else -> Position(x, y, orientation)
            }
        } else if (orientation == "E") {
            when (command) {
                "R" -> {
                    Position(x, y, "S")
                }
                "L" -> {
                    Position(x, y, "N")
                }
                else -> Position(x, y, orientation)
            }
        } else if (orientation == "S") {
            when (command) {
                "R" -> {
                    Position(x, y, "W")
                }
                "L" -> {
                    Position(x, y, "E")
                }
                else -> Position(x, y, orientation)
            }
        } else if (orientation == "W") {
            when (command) {
                "R" -> {
                    Position(x, y, "N")
                }
                "L" -> {
                    Position(x, y, "S")
                }
                else -> Position(x, y, orientation)
            }
        } else
            Position(x, y, orientation)
}
