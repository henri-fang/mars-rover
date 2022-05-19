package com.tw.marsrover

import java.lang.IllegalStateException

class MarsRover(private val x: Int, private val y: Int, private val orientation: String) {

    fun position(): Position {
        return Position(x, y, orientation)
    }

    fun execute(command: Command): Position =
        when (command) {
            Command.L -> turnLeft()
            Command.R -> turnRight()
        }

    private fun turnRight(): Position {
        return when (orientation) {
            "N" -> Position(x, y, "E")
            "E" -> Position(x, y, "S")
            "S" -> Position(x, y, "W")
            "W" -> Position(x, y, "N")
            else -> throw IllegalStateException("incorrect orientation")
        }
    }

    private fun turnLeft(): Position {
        return when (orientation) {
            "N" -> Position(x, y, "W")
            "E" -> Position(x, y, "N")
            "S" -> Position(x, y, "E")
            "W" -> Position(x, y, "S")
            else -> throw IllegalStateException("incorrect orientation")
        }
    }
}
